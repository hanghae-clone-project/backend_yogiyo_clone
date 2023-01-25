package com.yogiyo.clone.domain.store.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreDataDto {
    private Integer status;
    private String message;
    private Object Data;

    public StoreDataDto(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        Data = data;
    }
}
