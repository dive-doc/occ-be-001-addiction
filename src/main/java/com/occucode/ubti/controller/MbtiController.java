package com.occucode.ubti.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.occucode.ubti.dto.MbtiQuestionResponseDto;
import com.occucode.ubti.dto.MbtiQuestionSubmitFriendRequestDto;
import com.occucode.ubti.dto.MbtiQuestionSubmitSelfRequestDto;
import com.occucode.ubti.dto.MbtiQuestionSubmitResponseDto;
import com.occucode.ubti.service.MbtiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("mbti")
@RequiredArgsConstructor
public class MbtiController {

  private final MbtiService mbtiService;

  // mbti 질문리스트 받기
  @GetMapping(value = "/question")
  public ResponseEntity<List<MbtiQuestionResponseDto>> handleGetMbtiQuestList() {
    return new ResponseEntity<>(
      mbtiService.getMbtiQuestList(),
      HttpStatus.OK
    );
  }

  // mbti 검사 후 제출 (self)
  @GetMapping(value = "/question/submit/self")
  public ResponseEntity<MbtiQuestionSubmitResponseDto> handleSubmitQuestionSelf(
    @RequestBody MbtiQuestionSubmitSelfRequestDto mbtiQuestionSubmitSelfRequestDto
  ) throws JsonProcessingException {
    return new ResponseEntity<>(
      mbtiService.submitQuestionSelf(mbtiQuestionSubmitSelfRequestDto),
      HttpStatus.OK
    );
  }

  // 친구 mbti 검사 후 제출
  @GetMapping(value = "/question/submit/friend")
  public ResponseEntity<MbtiQuestionSubmitResponseDto> handleSubmitQuestionFriend(
    @RequestBody MbtiQuestionSubmitFriendRequestDto mbtiQuestionSubmitFriendRequestDto
  ) throws JsonProcessingException {
    return new ResponseEntity<>(
      mbtiService.submitQuestionFriend(mbtiQuestionSubmitFriendRequestDto),
      HttpStatus.OK
    );
  }
}
