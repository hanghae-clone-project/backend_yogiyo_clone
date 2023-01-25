package com.yogiyo.clone.domain.store.controller;

import com.yogiyo.clone.domain.store.dto.StoreDataDto;
import com.yogiyo.clone.domain.store.dto.StoreListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    @GetMapping
    public ResponseEntity<StoreListDto> storeList() {
        // 서비스 로직
        StoreListDto storeListDto = new StoreListDto();
        return new ResponseEntity<>(storeListDto, HttpStatus.OK);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<StoreDataDto> toStore(@PathVariable Long storeId) {
        // 서비스 로직
        StoreDataDto storeDataDto = new StoreDataDto();
        return new ResponseEntity<>(storeDataDto, HttpStatus.OK);
    }

}
