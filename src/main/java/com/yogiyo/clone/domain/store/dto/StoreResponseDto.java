package com.yogiyo.clone.domain.store.dto;

import com.yogiyo.clone.domain.menu.dto.MenuListDto;
import com.yogiyo.clone.domain.temporary_admin.entity.Menu;
import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class StoreResponseDto {

    private Long id;

    private String storeName;

    private String imageUrl;

    private int score;

//    private int deliveryTime;

    private List<MenuListDto> storeMenu = new ArrayList<>();

    public StoreResponseDto(Store store) {
        this.id = store.getId();
        this.storeName = store.getStoreName();
        this.imageUrl = store.getImageUrl();
        this.score = store.getScore();
//        this.deliveryTime = deliveryTime;
        List<Menu> menues = store.getMenu();
        for (Menu menu : menues) {
            this.storeMenu.add(new MenuListDto(menu));
        }
    }
}
