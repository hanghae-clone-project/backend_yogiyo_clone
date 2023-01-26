package com.yogiyo.clone.domain.temporary_admin.controller;

import com.yogiyo.clone.domain.user.dto.LoginForm;
import com.yogiyo.clone.domain.user.entity.Users;
import com.yogiyo.clone.domain.user.service.UserService;
import com.yogiyo.clone.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.yogiyo.clone.security.jwt.JwtUtil.AUTHORIZATION_HEADER;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @RequestMapping("/login")
    public String adminLogin() {
        return "admin_login";
    }

    @RequestMapping("/signup")
    public String adminSignup() {
        return "admin_signup";
    }

    @PostMapping("/main")
    public String login(@RequestParam String username,@RequestParam String password,LoginForm loginForm,
                        HttpServletRequest request, HttpServletResponse response) {

        loginForm.setEmail(username);
        loginForm.setPassword(password);
        Users users = userService.login(loginForm);
        response.addHeader(AUTHORIZATION_HEADER, jwtUtil.createToken(users.getUsername()));

        return "admin_main";
    }

}
