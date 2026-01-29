package com.study.spring.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.user.dto.UserInfoEmailCheckDTO;
import com.study.spring.user.dto.UserInfoNicknameCheckDTO;
import com.study.spring.user.repository.UserInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserInfoCheckController {

    @Autowired
    private UserInfoRepository userinforepo;
    
    @GetMapping("/api/userInfoEmailChk")
    public Optional<UserInfoEmailCheckDTO> userInfoEmailCheckYn(
            @RequestParam(name = "email") String email){
        // ...
        Optional<UserInfoEmailCheckDTO> userInfoEmailCheckYn = userinforepo.userInfoEmailCheckYn(email);
        return userInfoEmailCheckYn;
    }
    @GetMapping("/api/userInfoNicknameChk")
    public Optional<UserInfoNicknameCheckDTO> userInfoNicknameCheckYn(
            @RequestParam(name = "nickname") String nickname){
        // ...
        Optional<UserInfoNicknameCheckDTO> userInfoNicknameCheckYn = userinforepo.userInfoNicknameCheckYn(nickname);
        return userInfoNicknameCheckYn;
    }
}