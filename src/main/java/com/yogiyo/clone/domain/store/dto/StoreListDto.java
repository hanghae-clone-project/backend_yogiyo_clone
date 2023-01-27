package com.yogiyo.clone.domain.store.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreListDto {
    private Long id;
//    private String imageUrl;
    private String store_name;
//    private int score;
//    private int deliveryTime;

    public StoreListDto(Store store) {
        this.id = store.getId();
//        this.imageUrl = store.getImageUrl;
        this.store_name = store.getStore_name();
//        this.score = score;
//        this.deliveryTime = deliveryTime;
    }
}
