package com.yogiyo.clone.domain.temporary_admin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreAddRequestDto {

    private Long id;

    private String imageUrl;

    private String storeName;

    private int score;

//    private int deliveryTime;

}
