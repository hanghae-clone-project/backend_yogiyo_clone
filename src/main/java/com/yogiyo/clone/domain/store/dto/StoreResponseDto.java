package com.yogiyo.clone.domain.store.dto;

import com.yogiyo.clone.domain.menu.dto.MenuResponseDto;
import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import com.yogiyo.clone.domain.temporary_admin.entity.Store_menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class StoreResponseDto {

    private Long id;

    private String storeName;

//    private String imageUrl;

//    private int score;

//    private int deliveryTime;

    private List<MenuResponseDto> storeMenu = new ArrayList<>();

    public StoreResponseDto(Store store) {
        this.id = store.getId();
        this.storeName = store.getStore_name();
//        this.imageUrl = imageUrl;
//        this.score = score;
//        this.deliveryTime = deliveryTime;
        List<Store_menu> menu = store.getMenu();
        for (Store_menu store_menu : menu) {
            this.storeMenu.add(new MenuResponseDto(store_menu));
        }
    }
}
