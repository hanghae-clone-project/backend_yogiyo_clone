package com.yogiyo.clone.domain.temporary_admin.controller;

import com.yogiyo.clone.domain.temporary_admin.dto.*;
import com.yogiyo.clone.domain.temporary_admin.service.AdminApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminApiController {

    private final AdminApiService adminApiService;

    @GetMapping("/getMenuList")
    public List<AdminMenuResponseDto> getMenuList() {
        return adminApiService.getMenuList();
    }

    @PostMapping("/store")
    public StoreAddResponseDto addStore(@RequestBody StoreAddRequestDto dto) {
        return adminApiService.addStore(dto);
    }

    @PostMapping("/menu/{store_id}")
    public MenuAddResponseDto addMenu(@PathVariable Long store_id, @RequestBody MenuAddRequestDto dto) {
        return adminApiService.addMenu(store_id, dto);
    }
}
