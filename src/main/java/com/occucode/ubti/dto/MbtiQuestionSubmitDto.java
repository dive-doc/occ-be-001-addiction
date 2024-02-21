package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MbtiQuestionSubmitDto {
  @JsonProperty("questionNum")
  private Long questionNum;

  @JsonProperty("itemNum")
  private Long itemNum;
}
