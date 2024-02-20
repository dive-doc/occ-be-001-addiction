package com.occucode.ubti.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.occucode.ubti.dto.MbtiQuestionResponseDto;
import com.occucode.ubti.dto.MbtiQuestionSubmitFriendRequestDto;
import com.occucode.ubti.dto.MbtiQuestionSubmitSelfRequestDto;
import com.occucode.ubti.dto.MbtiQuestionSubmitResponseDto;
import com.occucode.ubti.service.MbtiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "MBTI", description = "MBTI 관련 API")
@RestController
@RequestMapping("/mbti")
@RequiredArgsConstructor
public class MbtiController {

  @Autowired
  private final MbtiService mbtiService;

  @Operation(summary = "MBTI 검사 전체 질문 리스트 조회", description = "MBTI 검사 전체 질문 리스트 조회합니다.")
  @GetMapping(value = "/question")
  public ResponseEntity<List<MbtiQuestionResponseDto>> handleGetMbtiQuestList() {
    return new ResponseEntity<>(
      mbtiService.getMbtiQuestList(),
      HttpStatus.OK
    );
  }

  @Operation(summary = "나의 MBTI 검사 후 제출 (self)", description = "MBTI 검사 후 대답 리스트를 제출합니다.")
  @PostMapping(value = "/question/submit/self")
  public ResponseEntity<MbtiQuestionSubmitResponseDto> handleSubmitQuestionSelf(
    @RequestBody MbtiQuestionSubmitSelfRequestDto mbtiQuestionSubmitSelfRequestDto
  ) throws JsonProcessingException {
    return new ResponseEntity<>(
      mbtiService.submitQuestionSelf(mbtiQuestionSubmitSelfRequestDto),
      HttpStatus.OK
    );
  }

  @Operation(summary = "친구의 MBTI 검사 후 제출 (friend)", description = "친구의 MBTI 검사 후 대답 리스트를 제출합니다.")
  @PostMapping(value = "/question/submit/friend")
  public ResponseEntity<MbtiQuestionSubmitResponseDto> handleSubmitQuestionFriend(
    @RequestBody MbtiQuestionSubmitFriendRequestDto mbtiQuestionSubmitFriendRequestDto
  ) throws JsonProcessingException {
    return new ResponseEntity<>(
      mbtiService.submitQuestionFriend(mbtiQuestionSubmitFriendRequestDto),
      HttpStatus.OK
    );
  }
}
