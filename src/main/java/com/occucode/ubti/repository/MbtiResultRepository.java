package com.occucode.ubti.repository;

import com.occucode.ubti.entity.MbtiResult;
import com.occucode.ubti.enums.MbtiEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MbtiResultRepository extends JpaRepository<MbtiResult, Long> {

  MbtiResult findByMbti(MbtiEnum mbti);
}
