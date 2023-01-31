package com.yogiyo.clone.domain.temporary_admin.dto;

import lombok.Getter;

@Getter
public class MenuDeleteResponseDto {

    private Integer status;
    private String message;

    public MenuDeleteResponseDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
