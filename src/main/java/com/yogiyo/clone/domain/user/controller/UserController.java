package com.yogiyo.clone.domain.user.controller;

import com.yogiyo.clone.domain.user.dto.SignUpForm;
import com.yogiyo.clone.domain.user.dto.SignUpResponseMessage;
import com.yogiyo.clone.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/signup")
    public ResponseEntity<SignUpResponseMessage> createUser(@RequestBody SignUpForm signUpForm) {

        userService.signUp(signUpForm);

        return new ResponseEntity<>(new SignUpResponseMessage(OK.value(), "회원 가입 완료"), OK);
    }
}
