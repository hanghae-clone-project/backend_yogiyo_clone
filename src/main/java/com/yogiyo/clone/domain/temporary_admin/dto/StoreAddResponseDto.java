package com.yogiyo.clone.domain.temporary_admin.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreAddResponseDto {

    private Long store_id;
    private String store_name;

    public StoreAddResponseDto(Store store) {
        this.store_id = store.getId();
        this.store_name = store.getStore_name();
    }

}
