package com.yogiyo.clone.util;

import com.yogiyo.clone.domain.user.entity.Users;
import com.yogiyo.clone.domain.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class TimeStampedTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MockMvc mvc;

    @BeforeEach
    void beforeEach() {
        userRepository.deleteAll();
    }


    @DisplayName("성공 케이스 - 유저 엔티티 저장 시 - 생성 시간, 수정 시간 생성")
    @Test
    void test1() throws Exception {
        //given
        mvc.perform(MockMvcRequestBuilders.post("/users/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\" : \"자몽\", \"email\": \"example@email.com\", \"password\": \"123456Aa#\"}"))
                .andExpect(status().isCreated());

        //when
        Users findUser = userRepository.findByUsername("자몽").get();

        //then
        Assertions.assertThat(findUser.getCreateAt()).isNotNull();
        Assertions.assertThat(findUser.getModifiedAt()).isNotNull();

    }
}