package com.yogiyo.clone.domain.temporary_admin.entity;

import com.yogiyo.clone.domain.temporary_admin.dto.StoreAddRequestDto;
import com.yogiyo.clone.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(nullable = false)
    private String storeName;

    private String imageUrl;

    private int score;

//    private int deliveryTime;

    @OneToMany(mappedBy = "store", orphanRemoval = true)
    private List<Menu> menu = new ArrayList<>();

    public Store(StoreAddRequestDto dto) {
        this.storeName = dto.getStoreName();
        this.imageUrl = dto.getImageUrl();
        this.score = dto.getScore();
    }
}
