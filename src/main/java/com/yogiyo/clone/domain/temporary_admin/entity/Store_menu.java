package com.yogiyo.clone.domain.temporary_admin.entity;

import com.yogiyo.clone.domain.temporary_admin.dto.MenuAddRequestDto;
import com.yogiyo.clone.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Store_menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @Column(nullable = false)
    private String menu_name;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Store_menu(MenuAddRequestDto dto, Store store) {
        this.menu_name = dto.getMenu_name();
        this.store = store;
    }

}
