//package com.yogiyo.clone.domain.user.controller;
//
//import com.yogiyo.clone.domain.user.repository.UserRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@AutoConfigureMockMvc
//@SpringBootTest
//class UserControllerTest {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    MockMvc mvc;
//
//    @BeforeEach
//    void beforeEach() {
//        userRepository.deleteAll();
//    }
//
//    @DisplayName("회원 가입 성공 - 회원가입 요청 시 - 상태코드 201, 회원 엔티티가 저장된다.")
//    @Test
//    void test1() throws Exception {
//
//        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"username\" : \"abc1234\", \"email\": \"example@email.com\", \"password\": \"123456Aa\"}"))
//                .andExpect(status().isCreated());
//
//        Assertions.assertThat(userRepository.findByUsername("abc1234").isPresent()).isTrue();
//    }
//
//    @DisplayName("회원 가입 실패 - 아이디, 이메일 중복 시 - 상태코드 400, 예외 메시지를 반환한다. ")
//    @Test
//    void test2() throws Exception {
//        String expectedExceptionMessage = "$.[?(@.message == '%s')]";
//
//        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"username\" : \"example123\", \"email\": \"example1@email.com\", \"password\": \"123456Aa\"}"))
//                .andExpect(status().isCreated());
//
//        //이메일 중복
//        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"username\" : \"example1234\", \"email\": \"example1@email.com\", \"password\": \"123456Aa\"}"))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath(expectedExceptionMessage, "이미 존재하는 이메일입니다.").exists());
//
//        //닉네임 중복
//        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"username\" : \"example123\", \"email\": \"example2@email.com\", \"password\": \"123456Aa\"}"))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath(expectedExceptionMessage, "이미 존재하는 닉네임입니다.").exists());
//
//    }
//
//    @DisplayName("회원 가입 - 회원 가입에 필요한 필드 규칙 미준수 시 - 상태 코드 400, 예외 메시지 반환")
//    @Test
//    void test3() throws Exception {
//        //JsonPath 표현식
//        String expectedExceptionMessage = "$.[?(@.messages == ['%s'])]";
//
//        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"username\" : \"abc@#\", \"email\": \"field2@email.com\", \"password\": \"123456Aa\"}"))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath(expectedExceptionMessage, "닉네임은 4 ~ 12자 사이 그리고 한글, 영문, 숫자만 가능합니다.").exists());
//
//    }
//
//    @DisplayName("로그인 성공 - 케이스")
//    @Test
//    void test4() throws Exception {
//        //given
//        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"username\" : \"abc1234\", \"email\": \"success1@email.com\", \"password\": \"123456Aa\"}"))
//                        .andReturn();
//
//        //when
//        mvc.perform(MockMvcRequestBuilders.post("/users/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"email\": \"success1@email.com\", \"password\": \"123456Aa\"}"))
//                //then
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.header().exists("Authorization"));
//
//    }
//
//    @DisplayName("로그인 실패 - 비밀번호, 아이디 불일치 - 상태코드 400, 예외 메시지 반환")
//    @Test
//    void test5() throws Exception {
//        //given
//        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"username\" : \"abc1234\", \"email\": \"login@email.com\", \"password\": \"123456Aa\"}"))
//                .andReturn();
//
//        //JsonPath 표현식
//        String expectedExceptionMessage = "$.[?(@.message == '%s')]";
//
//        //when - 비밀번호 불일치
//
//        mvc.perform(MockMvcRequestBuilders.post("/users/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"email\": \"login@email.com\", \"password\": \"incorrectPwd\"}"))
//                //then
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath(expectedExceptionMessage, "아이디/비밀번호가 올바르지 않습니다.").exists());
//
//        //when - 아이디 불일치
//        mvc.perform(MockMvcRequestBuilders.post("/users/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"email\": \"loginfail@email.com\", \"password\": \"123456Aa\"}"))
//                //then
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath(expectedExceptionMessage, "아이디/비밀번호가 올바르지 않습니다.").exists());
//    }
//}