package com.occucode.ubti.repository;

import com.occucode.ubti.entity.Note;
import com.occucode.ubti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

  List<Note> findAllByUser(User user);
}
