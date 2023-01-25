package com.yogiyo.clone.domain.user.dto;

import lombok.Getter;

@Getter
public class SignUpResponseMessage {

    private Integer status;
    private String message;

    public SignUpResponseMessage(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
