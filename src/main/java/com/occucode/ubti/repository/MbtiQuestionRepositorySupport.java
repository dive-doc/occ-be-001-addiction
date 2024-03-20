package com.occucode.ubti.repository;

import com.occucode.ubti.entity.MbtiQuestion;

import java.util.List;

public interface MbtiQuestionRepositorySupport {
  List<MbtiQuestion> findAllWithAnswer();

}
