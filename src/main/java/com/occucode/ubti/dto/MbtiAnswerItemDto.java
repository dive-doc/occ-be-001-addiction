package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MbtiAnswerItemDto {
  @JsonProperty("itemNum")
  private Long itemNum;

  @JsonProperty("description")
  private String description;
}
