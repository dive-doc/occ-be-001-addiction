package com.occucode.ubti.controller;

import com.occucode.ubti.dto.NoteRequestDto;
import com.occucode.ubti.dto.NoteResponseDto;
import com.occucode.ubti.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Note", description = "Note 관련 API")
@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

  private final NoteService noteService;

  @Operation(summary = "Note 조회", description = "나의 전체 메모(note)를 조회합니다.")
  @GetMapping(value = "/note/{userNum}")
  public ResponseEntity<List<NoteResponseDto>> handleGetNoteList(@PathVariable Long userNum) {
    return new ResponseEntity<>(
      noteService.getNoteList(userNum),
      HttpStatus.OK
    );
  }

  @Operation(summary = "Note 생성", description = "친구의 게시판에 메모(note)를 추가합니다.")
  @PostMapping(value = "/note")
  public ResponseEntity<Long> handleCreateNote(@RequestBody NoteRequestDto noteRequestDto) {
    return new ResponseEntity<>(
      noteService.createNote(noteRequestDto),
      HttpStatus.OK
    );
  }

}
