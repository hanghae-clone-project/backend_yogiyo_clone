package com.yogiyo.clone.domain.menu.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuListDto {
    private Long id;
    private String menuName;
    private String imageUrl;
    private String details;
    private int price;
//    private int deliveryTime;
    private int amount;

    public MenuListDto(Menu menu) {
        this.id = menu.getId();
        this.menuName = menu.getMenuName();
        this.imageUrl = menu.getImageUrl();
        this.details = menu.getDetails();
        this.price = menu.getPrice();
//        this.deliveryTime = menu.getDeliveryTime;
        this.amount = 1;
    }
}
