package com.yogiyo.clone.domain.store.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreMessageDto {
    private Integer status;
    private String message;

    public StoreMessageDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
