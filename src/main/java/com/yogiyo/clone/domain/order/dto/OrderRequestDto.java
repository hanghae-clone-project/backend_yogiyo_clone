package com.yogiyo.clone.domain.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderRequestDto {

    private List<OrderSaveDto> storeMenu;

}
