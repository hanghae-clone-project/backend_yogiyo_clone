package com.yogiyo.clone.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginForm {
    private String email;
    private String password;
}
