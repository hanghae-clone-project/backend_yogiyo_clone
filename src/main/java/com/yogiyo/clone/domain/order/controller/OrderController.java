package com.yogiyo.clone.domain.order.controller;

import com.yogiyo.clone.domain.order.dto.OrderDataDto;
import com.yogiyo.clone.domain.order.dto.OrderRequestDto;
import com.yogiyo.clone.domain.order.service.OrderService;
import com.yogiyo.clone.domain.store.dto.StoreDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    //주문
    @PostMapping(value = "/stores/{storeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDataDto> order(@PathVariable Long storeId, @RequestBody OrderRequestDto storeMenu) {
        String storeName = orderService.order(storeId, storeMenu);

        OrderDataDto orderDataDto = new OrderDataDto(200, "가게 조회 완료", storeName);
        return new ResponseEntity<>(orderDataDto, HttpStatus.OK);
    }
}
