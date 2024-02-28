package com.occucode.ubti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.occucode.ubti.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class NoteResponseDto {

  @JsonProperty("noteNum")
  private Long noteNum;

  @JsonProperty("noteDetail")
  private String noteDetail;

  public static NoteResponseDto toDto(
    Note note
  ) {
    return NoteResponseDto.builder()
      .noteNum(note.getNoteNum())
      .noteDetail(note.getNoteDetail())
      .build();
  }
}
