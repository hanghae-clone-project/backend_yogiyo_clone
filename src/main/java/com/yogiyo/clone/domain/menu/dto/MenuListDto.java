package com.yogiyo.clone.domain.menu.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store_menu;
import lombok.Getter;

@Getter
public class MenuListDto {
    private Long id;
    //    private String imageUrl;
    private String menu_name;
//    private int score;
//    private int deliveryTime;

    public MenuListDto(Store_menu menu) {
        this.id = menu.getId();
//        this.imageUrl = menu.getImageUrl;
        this.menu_name = menu.getMenu_name();
//        this.score = score;
//        this.deliveryTime = deliveryTime;
    }
}
