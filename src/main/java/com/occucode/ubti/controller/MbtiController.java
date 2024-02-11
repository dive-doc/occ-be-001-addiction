package com.occucode.ubti.controller;

import com.occucode.ubti.dto.MbtiQuestionResponseDto;
import com.occucode.ubti.service.MbtiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("mbti")
@RequiredArgsConstructor
public class MbtiController {

  private final MbtiService mbtiService;

  @GetMapping(value = "/question")
  public ResponseEntity<List<MbtiQuestionResponseDto>> handleGetMbtiQuestList() {
    return new ResponseEntity(
      mbtiService.getMbtiQuestList(),
      HttpStatus.OK
    );
  }
}
