package com.yogiyo.clone.domain.store.controller;

import com.yogiyo.clone.domain.store.dto.StoreDataDto;
import com.yogiyo.clone.domain.store.dto.StoreListDto;
import com.yogiyo.clone.domain.store.dto.StoreResponseDto;
import com.yogiyo.clone.domain.store.service.StoreService;
import com.yogiyo.clone.domain.temporary_admin.service.AdminApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    //가게 전체 조회
    @GetMapping
    public ResponseEntity<StoreDataDto> storeList() {
        List<StoreListDto> storeList = storeService.getStoreList();
        StoreDataDto dto = new StoreDataDto(200, "가게 전체 조회 완료", storeList);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //가게 단건 조회
    @GetMapping("/{storeId}")
    public ResponseEntity<StoreDataDto> toStore(@PathVariable Long storeId) {
        StoreResponseDto foundStore = storeService.getStore(storeId);
        StoreDataDto storeDataDto = new StoreDataDto(200,"가게 조회 완료", foundStore);
        return new ResponseEntity<>(storeDataDto, HttpStatus.OK);
    }

}
