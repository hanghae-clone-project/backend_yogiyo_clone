package com.yogiyo.clone.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpForm {

    private String username;
    private String email;
    private String password;

    public SignUpForm(SignUpForm form, String encryptPassword) {
        this.username = form.getUsername();
        this.email = form.getEmail();
        this.password = encryptPassword;
    }
}
