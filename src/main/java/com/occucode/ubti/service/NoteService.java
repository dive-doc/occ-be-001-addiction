package com.occucode.ubti.service;

import com.occucode.ubti.dto.NoteRequestDto;
import com.occucode.ubti.dto.NoteResponseDto;

import java.util.List;

public interface NoteService {

  List<NoteResponseDto> getNoteList(Long userNum);

  Long createNote(NoteRequestDto noteRequest);
}
