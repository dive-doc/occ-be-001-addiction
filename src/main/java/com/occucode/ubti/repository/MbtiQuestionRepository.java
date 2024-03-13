package com.occucode.ubti.repository;

import com.occucode.ubti.entity.MbtiQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MbtiQuestionRepository extends JpaRepository<MbtiQuestion, Long> {
}
