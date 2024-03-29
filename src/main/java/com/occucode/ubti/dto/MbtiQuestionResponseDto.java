package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.occucode.ubti.entity.MbtiQuestion;
import com.occucode.ubti.vo.MbtiAnswerItemVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@AllArgsConstructor
@Builder
public class MbtiQuestionResponseDto {
  @JsonProperty("questionNum")
  private Long questionNum;

  @JsonProperty("description")
  private String description;

  @JsonProperty("itemList")
  private List<MbtiAnswerItemVo> itemList;

  public static MbtiQuestionResponseDto toDto(MbtiQuestion mbtiQuestion) {
    return MbtiQuestionResponseDto.builder()
      .questionNum(mbtiQuestion.getQuestionNum())
      .description(mbtiQuestion.getDescription())
      .itemList(mbtiQuestion.getMbtiAnswerItemList()
        .stream()
        .map(MbtiAnswerItemVo::toMbtiAnswerItemVo).collect(toList()))
      .build();
  }
}
