package com.yogiyo.clone.domain.temporary_admin.controller;

import com.yogiyo.clone.domain.temporary_admin.dto.*;
import com.yogiyo.clone.domain.temporary_admin.service.AdminApiService;
import com.yogiyo.clone.domain.user.dto.SignUpResponseMessage;
import com.yogiyo.clone.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminApiController {

    private final AdminApiService adminApiService;

    @GetMapping("/store-menu")
    public List<AdminMenuResponseDto> getMenuList() {
        return adminApiService.getMenuList();
    }

    @PostMapping("/store/{user_id}")
    public StoreAddResponseDto addStore(@PathVariable Long user_id, @RequestBody StoreAddRequestDto dto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return adminApiService.addStore(dto, user_id);
    }

    @PostMapping("/menu/{store_id}")
    public MenuAddResponseDto addMenu(@PathVariable Long store_id, @RequestBody MenuAddRequestDto dto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return adminApiService.addMenu(store_id, dto, userDetails.getUser());
    }

    @DeleteMapping("/menu/menu-delete/{menu_id}")
    public ResponseEntity<MenuDeleteResponseDto> deleteMenu(@PathVariable("menu_id") Long menu_id) {
        adminApiService.deleteMenu(menu_id);
        return new ResponseEntity<>(new MenuDeleteResponseDto(OK.value(), "삭제 완료"), OK);
    }
}
