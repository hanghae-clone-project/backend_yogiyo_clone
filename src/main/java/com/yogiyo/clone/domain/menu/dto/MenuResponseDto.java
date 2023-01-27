package com.yogiyo.clone.domain.menu.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store_menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuResponseDto {

    private Long id;

    private String menuName;

//    private String imageUrl;

//    private String details;

//    private int price;

    public MenuResponseDto(Store_menu menu) {
        this.id = menu.getId();
        this.menuName = menu.getMenu_name();
//        this.imageUrl = menu.getImageUrl;
//        this.details = details;
//        this.price = price;
    }
}
