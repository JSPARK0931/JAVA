package com.study.spring.member.repository;

import com.study.spring.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, String> {
    // 닉네임 중복 확인 로직 (Spring Data JPA가 쿼리 자동 생성)
    boolean existsByNickname(String nickname);
}