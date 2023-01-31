package com.yogiyo.clone.domain.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderSaveDto {

    private Long id;
    private String menuName;
    private int price;
    private int amount;
}
