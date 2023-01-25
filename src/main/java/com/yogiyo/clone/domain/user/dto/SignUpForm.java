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
    @Pattern(regexp = "(?=.*[a-zA-Z])(?=.*[0-9]).{4,15}$",
             message = "회원 가입 실패 / 아이디는 4 ~ 15자 사이 그리고 영문, 숫자를 포함해야 합니다.")
    private String username;

    @Email(message = "회원 가입 실패 / 이메일 형식으로 입력해야 합니다.")
    private String email;

    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,15}$",
             message = "회원 가입 실패 / 비밀번호는 8 ~ 15자 사이 그리고 소문자, 대문자, 숫자를 포함해야 합니다.")
    private String password;

    public SignUpForm(SignUpForm form, String encryptPassword) {
        this.username = form.getUsername();
        this.email = form.getEmail();
        this.password = encryptPassword;
    }
}
