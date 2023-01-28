package com.yogiyo.clone.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class SignUpForm {

    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Zㄱ-ㅎ가-힣]{2,12}$",
             message = "닉네임은 2 ~ 12자 사이 그리고 한글, 영문, 숫자만 가능합니다.")
    private String username;

    @Email(message = "이메일 형식으로 입력해야 합니다.")
    private String email;

    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*+=-]).{8,15}$",
             message = "비밀번호는 8 ~ 15자 사이 그리고 소문자, 대문자, 숫자, 특수문자(!@#$%^*+=-)를 포함해야 합니다.")
    private String password;

    private String userRole = "";

    public SignUpForm(SignUpForm form, String encryptPassword) {
        this.username = form.getUsername();
        this.email = form.getEmail();
        this.password = encryptPassword;
    }
}
