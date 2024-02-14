package com.occucode.ubti.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.occucode.ubti.dto.*;
import com.occucode.ubti.entity.MbtiResult;
import com.occucode.ubti.entity.OtherMbtiLog;
import com.occucode.ubti.entity.SelfMbtiLog;
import com.occucode.ubti.entity.User;
import com.occucode.ubti.enums.MbtiEnum;
import com.occucode.ubti.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MbtiServiceImpl implements MbtiService{

  @Autowired
  MbtiAnswerItemRepository mbtiAnswerItemRepository;

  @Autowired
  MbtiQuestionRepository mbtiQuestionRepository;

  @Autowired
  MbtiResultRepository mbtiResultRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  SelfMbtiLogRepository selfMbtiLogRepository;

  @Autowired
  OtherMbtiLogRepository otherMbtiLogRepository;

  // TODO: queryDsl 고려 (question - item, fetchJoin)
  @Transactional(readOnly = true)
  public List<MbtiQuestionResponseDto> getMbtiQuestList() {
    // TODO: builder 적용
    return mbtiQuestionRepository.findAll()
      .stream()
      .map(mbtiQuestion ->
        new MbtiQuestionResponseDto(
          mbtiQuestion.getQuestionNum(),
          mbtiQuestion.getDescription(),
          mbtiQuestion.getMbtiAnswerItemList()
            .stream()
            .map(mbtiAnswerItem ->
              new MbtiAnswerItemDto(mbtiAnswerItem.getItemNum(), mbtiAnswerItem.getDescription())
            ).collect(toList())
        )
      ).collect(toList());
  }

  @Transactional
  public MbtiQuestionSubmitResponseDto submitQuestionSelf(
    MbtiQuestionSubmitSelfRequestDto mbtiQuestionSubmitSelfRequestDto
  ) throws JsonProcessingException {
    // STEP 1 : 결과 도출
    MbtiEnum mbti = MbtiEnum.ENFP; // TODO: 결과 도출 로직 도입 예정

    // STEP 2 : save self log
    User user = userRepository.findById(
      mbtiQuestionSubmitSelfRequestDto.getUserNum()
    ).orElseThrow();

    ObjectMapper mapper = new ObjectMapper();
    selfMbtiLogRepository.save(
      SelfMbtiLog.toEntity(
        mapper.writeValueAsString(mbtiQuestionSubmitSelfRequestDto.getSubmitList()),
        mbti, user
      )
    );

    // STEP 3 : response
    MbtiResult mbtiResult = mbtiResultRepository.findByMbti(mbti);
    return MbtiQuestionSubmitResponseDto.toDto(mbtiResult);
  }

  @Transactional
  public MbtiQuestionSubmitResponseDto submitQuestionFriend(
    MbtiQuestionSubmitFriendRequestDto mbtiQuestionSubmitFriendRequestDto
  ) throws JsonProcessingException {
    // STEP 1 : 결과 도출
    MbtiEnum mbti = MbtiEnum.ENFP; // TODO: 결과 도출 로직 도입 예정

    // STEP 2 : save self log
    User from = userRepository.findById(
      mbtiQuestionSubmitFriendRequestDto.getFromUserNum()
    ).orElseThrow();

    User to = userRepository.findById(
      mbtiQuestionSubmitFriendRequestDto.getToUserNum()
    ).orElseThrow();

    ObjectMapper mapper = new ObjectMapper();
    otherMbtiLogRepository.save(
      OtherMbtiLog.toEntity(
        mapper.writeValueAsString(mbtiQuestionSubmitFriendRequestDto.getSubmitList()),
        mbti, to, from
      )
    );

    // STEP 3 : response
    MbtiResult mbtiResult = mbtiResultRepository.findByMbti(mbti);
    return MbtiQuestionSubmitResponseDto.toDto(mbtiResult);
  }
}
