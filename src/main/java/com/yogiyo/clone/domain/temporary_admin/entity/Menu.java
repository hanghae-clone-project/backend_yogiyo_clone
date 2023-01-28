package com.yogiyo.clone.domain.temporary_admin.entity;

import com.yogiyo.clone.domain.temporary_admin.dto.MenuAddRequestDto;
import com.yogiyo.clone.domain.user.entity.Users;
import com.yogiyo.clone.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @Column(nullable = false)
    private String menuName;

    private String imageUrl;

    private String details;

    private int price;
    private String storeName;
    private Long userid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public Menu(MenuAddRequestDto menuAddRequestDto, Store store, Users users) {
        this.menuName = menuAddRequestDto.getMenuName();
        this.imageUrl = menuAddRequestDto.getImageUrl();
        this.details = menuAddRequestDto.getDetails();
        this.price = menuAddRequestDto.getPrice();
        this.store = store;
        this.storeName = store.getStoreName();
        this.userid = users.getId();
//        this.deliveryTime = menu.getDeliveryTime;
    }

}
