package com.yogiyo.clone.domain.temporary_admin.entity;

import com.yogiyo.clone.domain.temporary_admin.dto.StoreAddRequestDto;
import com.yogiyo.clone.domain.temporary_admin.dto.StoreAddResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(nullable = false)
    private String store_name;

    @OneToMany(mappedBy = "store")
    private List<Store_menu> menu = new ArrayList<>();

    public Store(StoreAddRequestDto dto) {
        this.store_name = dto.getStore_name();
    }

}
