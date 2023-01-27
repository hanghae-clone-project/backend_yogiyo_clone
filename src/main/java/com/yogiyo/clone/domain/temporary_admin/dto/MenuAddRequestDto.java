package com.yogiyo.clone.domain.temporary_admin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class MenuAddRequestDto {

    private String menuName;
    private String imageUrl;
    private String details;
    private int price;
//    private int deliveryTime;

}
