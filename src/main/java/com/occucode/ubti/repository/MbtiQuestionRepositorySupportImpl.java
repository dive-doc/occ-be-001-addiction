package com.occucode.ubti.repository;


import com.occucode.ubti.entity.MbtiQuestion;
import com.occucode.ubti.entity.QMbtiQuestion;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MbtiQuestionRepositorySupportImpl implements MbtiQuestionRepositorySupport {

  private final JPAQueryFactory jpaQueryFactory;


  @Override
  public List<MbtiQuestion> findAllWithAnswer() {
    QMbtiQuestion mbtiQuestion = QMbtiQuestion.mbtiQuestion;

    return jpaQueryFactory
      .selectFrom(mbtiQuestion)
      .leftJoin(mbtiQuestion.mbtiAnswerItemList).fetchJoin()
      .fetch();
  }
}
