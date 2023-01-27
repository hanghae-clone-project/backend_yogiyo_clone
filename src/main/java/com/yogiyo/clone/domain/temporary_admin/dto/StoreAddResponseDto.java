package com.yogiyo.clone.domain.temporary_admin.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreAddResponseDto {

    private Long id;
    private String storeName;
    private String imageUrl;
    private int score;

    public StoreAddResponseDto(Store store) {
        this.id = store.getId();
        this.storeName = store.getStoreName();
        this.imageUrl = store.getImageUrl();
        this.score = store.getScore();
    }

}
