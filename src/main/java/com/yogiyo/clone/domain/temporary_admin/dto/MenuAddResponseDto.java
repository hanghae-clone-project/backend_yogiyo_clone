package com.yogiyo.clone.domain.temporary_admin.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store_menu;
import lombok.Getter;

@Getter
public class MenuAddResponseDto {

    private Long id;
    private String menu_name;

    public MenuAddResponseDto(Store_menu menu) {
        this.id = menu.getId();
        this.menu_name = menu.getMenu_name();
    }
}
