package com.yogiyo.clone.domain.temporary_admin.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreAddResponseDto {

    private Long storeId;
    private String storeName;

    public StoreAddResponseDto(Store store) {
        this.storeId = store.getId();
        this.storeName = store.getStoreName();
    }

}
