package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MbtiQuestionSubmitFriendRequestDto {
  @JsonProperty("from")
  private Long fromUserNum;

  @JsonProperty("to")
  private Long toUserNum;

  @JsonProperty("submitList")
  private List<MbtiQuestionSubmitDto> submitList;
}
