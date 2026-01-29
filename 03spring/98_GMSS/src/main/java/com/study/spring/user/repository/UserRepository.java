package com.study.spring.user.repository;

import com.study.spring.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    // 닉네임 중복 확인 로직 (Spring Data JPA가 쿼리 자동 생성)
    boolean existsByNickname(String nickname);
}