package com.occucode.ubti.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.occucode.ubti.entity.MbtiAnswerItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MbtiAnswerItemVo {
  @JsonProperty("itemNum")
  private Long itemNum;

  @JsonProperty("description")
  private String description;

  public static MbtiAnswerItemVo toDMbtiAnswerItemVo(
    MbtiAnswerItem mbtiAnswerItem
  ) {
    return MbtiAnswerItemVo.builder()
      .itemNum(mbtiAnswerItem.getItemNum())
      .description(mbtiAnswerItem.getDescription())
      .build();
  }
}
