package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.occucode.ubti.entity.MbtiResult;
import com.occucode.ubti.enums.MbtiEnum;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MbtiQuestionSubmitResponseDto {
  @JsonProperty("resultNum")
  private Long resultNum;

  @JsonProperty("mbti")
  private MbtiEnum mbti;

  @JsonProperty("description")
  private String description;

  @JsonProperty("bestMbti")
  private MbtiEnum bestMbti;

  @JsonProperty("worstMbti")
  private MbtiEnum worstMbti;

  public static MbtiQuestionSubmitResponseDto toDto(
    MbtiResult mbtiResult
  ) {
    return MbtiQuestionSubmitResponseDto.builder()
      .resultNum(mbtiResult.getResultNum())
      .mbti(mbtiResult.getMbti())
      .description(mbtiResult.getDescription())
      .bestMbti(mbtiResult.getBestMbti())
      .worstMbti(mbtiResult.getWorstMbti())
      .build();
  }
}
