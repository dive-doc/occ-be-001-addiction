package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MbtiQuestionSubmitSelfRequestDto {
  // TODO: userNum 으로 변경
  @JsonProperty("userNum")
  private Long userNum;

  @JsonProperty("submitList")
  private List<MbtiQuestionSubmitDto> submitList;
}
