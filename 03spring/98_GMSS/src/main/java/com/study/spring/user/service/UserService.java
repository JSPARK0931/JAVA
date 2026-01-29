package com.study.spring.user.service;

import com.study.spring.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 닉네임 중복 체크
     * @return 중복이면 true, 사용 가능하면 false
     */
    @Transactional(readOnly = true)
    public boolean isNicknameDuplicated(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    /**
     * 이메일 중복 체크 (Supabase 연동 시나리오)
     * 실제로는 Supabase 클라이언트 라이브러리를 통해 호출합니다.
     */
    public boolean isEmailDuplicated(String email) {
        // TODO: Supabase Admin SDK 또는 REST API를 호출하여 auth.users 내 email 존재 여부 확인
        // 예: supabase.auth.admin.listUsers() 등을 활용
        return false; 
    }
}