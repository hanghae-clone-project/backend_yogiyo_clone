package com.yogiyo.clone.domain.menu.dto;

import lombok.Getter;

@Getter
public class MenuListDto {
    private Long id;
    private String imageUrl;
    private String storeName;
    private int score;
    private int deliveryTime;

}
