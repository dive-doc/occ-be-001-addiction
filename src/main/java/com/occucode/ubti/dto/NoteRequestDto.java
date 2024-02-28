package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteRequestDto {
  @JsonProperty("noteDetail")
  private String noteDetail;

  @JsonProperty("userNum")
  private Long userNum;
}
