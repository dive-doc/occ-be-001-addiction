package com.occucode.ubti.repository;

import com.occucode.ubti.entity.SelfMbtiLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfMbtiLogRepository extends JpaRepository<SelfMbtiLog, Long> {
}
