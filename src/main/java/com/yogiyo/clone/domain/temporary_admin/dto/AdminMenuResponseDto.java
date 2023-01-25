package com.yogiyo.clone.domain.temporary_admin.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AdminMenuResponseDto {

    private Long store_id;

    private String store_name;
    private List<AdminMenuListResponseDto> menuList;

    public AdminMenuResponseDto(Store store) {
        this.store_id = store.getId();
        this.store_name = store.getStore_name();
        this.menuList = store.getMenu().stream().map(AdminMenuListResponseDto::new).collect(Collectors.toList());
    }

}
