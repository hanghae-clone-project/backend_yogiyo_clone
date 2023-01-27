package com.yogiyo.clone.domain.temporary_admin.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AdminMenuResponseDto {

    private Long id;

    private String storeName;

    private List<AdminMenuListResponseDto> menuList;

    public AdminMenuResponseDto(Store store) {
        this.id = store.getId();
        this.storeName = store.getStoreName();
        this.menuList = store.getMenu().stream().map(AdminMenuListResponseDto::new).collect(Collectors.toList());
    }

}
