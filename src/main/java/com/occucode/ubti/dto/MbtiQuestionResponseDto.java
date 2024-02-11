package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MbtiQuestionResponseDto {
  @JsonProperty("questionNum")
  private Long questionNum;

  @JsonProperty("description")
  private String description;

  @JsonProperty("itemList")
  private List<MbtiAnswerItemDto> itemList;
}
