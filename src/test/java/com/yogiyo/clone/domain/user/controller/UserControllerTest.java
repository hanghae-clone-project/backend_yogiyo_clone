package com.yogiyo.clone.domain.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yogiyo.clone.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @DisplayName("회원 가입 - 성공 케이스")
    @Test
    void test1() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\" : \"abc1234\", \"email\": \"example@email.com\", \"password\": \"123456Aa\"}"))
                .andExpect(status().isCreated());
    }

    @DisplayName("회원 가입 - 실패 케이스 - 아이디/이메일 중복")
    @Test
    void test2() throws Exception {
        String expectedExceptionMessage = "$.[?(@.message == '%s')]";

        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\" : \"example123\", \"email\": \"example1@email.com\", \"password\": \"123456Aa\"}"))
                .andExpect(status().isCreated());

        //이메일 중복
        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\" : \"example1234\", \"email\": \"example1@email.com\", \"password\": \"123456Aa\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath(expectedExceptionMessage, "이미 존재하는 이메일입니다.").exists());

        //닉네임 중복
        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\" : \"example123\", \"email\": \"example2@email.com\", \"password\": \"123456Aa\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath(expectedExceptionMessage, "이미 존재하는 닉네임입니다.").exists());

    }

    @DisplayName("회원 가입 - 실패 케이스 - username 필드 검증 미통과")
    @Test
    void test3() throws Exception {
        String expectedExceptionMessage = "$.[?(@.messages == ['%s'])]";

        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\" : \"abc@#\", \"email\": \"field2@email.com\", \"password\": \"123456Aa\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath(expectedExceptionMessage, "닉네임은 4 ~ 12자 사이 그리고 한글, 영문, 숫자만 가능합니다.").exists());

    }
}