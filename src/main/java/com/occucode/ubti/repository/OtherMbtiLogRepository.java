package com.occucode.ubti.repository;

import com.occucode.ubti.entity.OtherMbtiLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherMbtiLogRepository extends JpaRepository<OtherMbtiLog, Long> {
}
