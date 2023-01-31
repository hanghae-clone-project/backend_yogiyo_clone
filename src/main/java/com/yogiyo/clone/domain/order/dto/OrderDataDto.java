package com.yogiyo.clone.domain.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDataDto {

    private Integer status;
    private String message;
    private String storeName;

    public OrderDataDto(Integer status, String message, String  storeName) {
        this.status = status;
        this.message = message;
        this.storeName = storeName;
    }
}
