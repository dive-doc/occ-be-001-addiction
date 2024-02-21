package com.occucode.ubti.repository;

import com.occucode.ubti.entity.MbtiAnswerItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MbtiAnswerItemRepository extends JpaRepository<MbtiAnswerItem, Long> {
}
