package com.occucode.ubti.repository;

import com.occucode.ubti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNickname(String nickname);
    User findByUserNum(Long userNum);
}
