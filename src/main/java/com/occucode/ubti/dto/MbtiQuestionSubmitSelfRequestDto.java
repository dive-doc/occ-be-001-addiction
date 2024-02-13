package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MbtiQuestionSubmitSelfRequestDto {
  @JsonProperty("userNum")
  private Long userNum;

  @JsonProperty("submitList")
  private List<MbtiQuestionSubmitDto> submitList;
}
