package com.occucode.ubti.service;

import com.occucode.ubti.dto.NoteRequestDto;
import com.occucode.ubti.dto.NoteResponseDto;
import com.occucode.ubti.entity.Note;
import com.occucode.ubti.entity.User;
import com.occucode.ubti.repository.NoteRepository;
import com.occucode.ubti.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

  private final NoteRepository noteRepository;
  private final UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  public List<NoteResponseDto> getNoteList(Long userNum) {
    User user = userRepository.findByUserNum(userNum);

    return noteRepository.findAllByUser(user).stream()
      .map(NoteResponseDto::toDto).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public Long createNote(NoteRequestDto noteRequest) {
    User user = userRepository.findByUserNum(noteRequest.getUserNum());

    return noteRepository.save(
      Note.toEntity(noteRequest.getNoteDetail(), user)
    ).getNoteNum();
  }
}
