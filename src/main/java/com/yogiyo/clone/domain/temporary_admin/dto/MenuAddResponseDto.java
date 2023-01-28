package com.yogiyo.clone.domain.temporary_admin.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Menu;
import lombok.Getter;

@Getter
public class MenuAddResponseDto {

    private Long id;
    private String menuName;
    private String imageUrl;
    private String details;
    private int price;
    private String storeName;
//    private int deliveryTime;

    public MenuAddResponseDto(Menu menu) {
        this.id = menu.getId();
        this.menuName = menu.getMenuName();
        this.imageUrl = menu.getImageUrl();
        this.details = menu.getDetails();
        this.price = menu.getPrice();
        this.storeName = menu.getStoreName();
    }
}
