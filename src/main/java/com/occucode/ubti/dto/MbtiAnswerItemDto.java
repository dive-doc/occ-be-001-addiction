package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.occucode.ubti.entity.MbtiAnswerItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MbtiAnswerItemDto {
  @JsonProperty("itemNum")
  private Long itemNum;

  @JsonProperty("description")
  private String description;

  public static MbtiAnswerItemDto toDto(
    MbtiAnswerItem mbtiAnswerItem
  ) {
    return MbtiAnswerItemDto.builder()
      .itemNum(mbtiAnswerItem.getItemNum())
      .description(mbtiAnswerItem.getDescription())
      .build();
  }
}
