package com.occucode.ubti.service;

import com.occucode.ubti.dto.MbtiAnswerItemDto;
import com.occucode.ubti.dto.MbtiQuestionResponseDto;
import com.occucode.ubti.repository.MbtiAnswerItemRepository;
import com.occucode.ubti.repository.MbtiQuestionRepository;
import com.occucode.ubti.repository.MbtiResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MbtiService {

  @Autowired
  MbtiAnswerItemRepository mbtiAnswerItemRepository;

  @Autowired
  MbtiQuestionRepository mbtiQuestionRepository;

  @Autowired
  MbtiResultRepository mbtiResultRepository;

  // TODO: queryDsl 고려 (question - item, fetchJoin)
  public List<MbtiQuestionResponseDto> getMbtiQuestList() {
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
}
