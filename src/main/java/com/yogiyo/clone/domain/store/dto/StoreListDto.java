package com.yogiyo.clone.domain.store.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreListDto {

    private Long id;

    private String imageUrl;

    private String storeName;

    private int score;

//    private int deliveryTime;

    public StoreListDto(Store store) {
        this.id = store.getId();
        this.imageUrl = store.getImageUrl();
        this.storeName = store.getStoreName();
        this.score = store.getScore();
//        this.deliveryTime = deliveryTime;
    }
}
