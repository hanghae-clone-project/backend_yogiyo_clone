package com.yogiyo.clone.security.jwt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.yogiyo.clone.security.jwt.JwtUtil.AUTHORIZATION_HEADER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 인증이 필요한 요청에 토큰에 따른 응답 결과 테스트
 */
@AutoConfigureMockMvc
@SpringBootTest
class JwtAuthFilterTest {

    @Autowired
    MockMvc mvc;

    @DisplayName("토큰 검증 실패 - 토큰이 없다면  - 403 반환")
    @Test
    void test1() throws Exception {
        mvc.perform(get("/stores"))
                .andExpect(status().isForbidden())
                .andExpect(MockMvcResultMatchers.header().doesNotExist(AUTHORIZATION_HEADER));

    }


    @DisplayName("토큰 검증 실패 - 유효하지 않은 토큰  - 401 반환")
    @Test
    void test2() throws Exception {

        String manipulatedToken = "Bearer eyJzdWIiOiLtj6zrj4QiLCJHAiOjE4ODQsImlhdCI6MTY3NDkwMDI4NH0" +
                ".p9L3iN3srObLZYB5NEywLbqBpKs-E4APolvTVui9WM8";

        mvc.perform(get("/stores")
                        .header(AUTHORIZATION_HEADER, manipulatedToken))
                .andExpect(status().isUnauthorized())
                .andExpect(MockMvcResultMatchers.header().doesNotExist(AUTHORIZATION_HEADER));

    }
    @DisplayName("토큰 검증 성공 - 인증이 필요한 요청에 유효한 토큰이 존재한다면 - 200 반환")
    @Test
    void test3() throws Exception {
        //given - 로그인을 해서 토크값이 주어지면
        mvc.perform(post("/users/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\" : \"abc1234\", \"email\": \"example@email.com\", \"password\": \"123456Aa#\"}"));


        MvcResult result = mvc.perform(post("/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"example@email.com\", \"password\": \"123456Aa#\"}"))
                .andReturn();

        //토큰
        String token = result.getResponse().getHeader("Authorization");

        //when
        mvc.perform(get("/stores")
                        .header(AUTHORIZATION_HEADER, token))
                //then
                .andExpect(status().isOk());

    }
}