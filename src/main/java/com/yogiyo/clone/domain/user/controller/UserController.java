package com.yogiyo.clone.domain.user.controller;

import com.yogiyo.clone.domain.user.dto.LoginForm;
import com.yogiyo.clone.domain.user.dto.SignUpForm;
import com.yogiyo.clone.domain.user.dto.SignUpResponseMessage;
import com.yogiyo.clone.domain.user.entity.Users;
import com.yogiyo.clone.domain.user.service.UserService;
import com.yogiyo.clone.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static com.yogiyo.clone.security.jwt.JwtUtil.AUTHORIZATION_HEADER;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/users/signup")
    public ResponseEntity<SignUpResponseMessage> createUser(@Validated @RequestBody SignUpForm signUpForm) {

        userService.checkedEmailDuplication(signUpForm);
        userService.checkedUsernameDuplication(signUpForm);

        userService.signUp(signUpForm);

        return new ResponseEntity<>(new SignUpResponseMessage(CREATED.value(), "회원 가입 완료"), CREATED);
    }

    @PostMapping("/users/login")
    public ResponseEntity<SignUpResponseMessage> loginUser(@RequestBody LoginForm loginForm,
                                            HttpServletResponse response) {


        Users users = userService.login(loginForm);
        response.addHeader(AUTHORIZATION_HEADER, jwtUtil.createToken(users.getUsername()));

        return new ResponseEntity<>(new SignUpResponseMessage(OK.value(), "로그인 완료"),OK);
    }
    @GetMapping("/auth/test")
    public String authTest(@AuthenticationPrincipal UserDetails userDetails) {

        return "username : " + userDetails.getUsername();
    }
}
