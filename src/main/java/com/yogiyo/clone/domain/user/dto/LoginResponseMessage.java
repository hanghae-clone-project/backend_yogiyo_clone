package com.yogiyo.clone.domain.user.dto;

import lombok.Getter;

@Getter
public class LoginResponseMessage {

    private Integer status;
    private String message;
    private String username;

    public LoginResponseMessage(Integer status, String message, String username) {
        this.status = status;
        this.message = message;
        this.username = username;
    }
}
