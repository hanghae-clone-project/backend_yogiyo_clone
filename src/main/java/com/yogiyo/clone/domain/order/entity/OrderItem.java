package com.yogiyo.clone.domain.order.entity;

import com.yogiyo.clone.domain.temporary_admin.entity.Menu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; //주문 가격

    private int amount;

    public OrderItem(Menu menu, int orderPrice, int amount, Order order) {
        this.menu = menu;
        this.orderPrice = orderPrice;
        this.amount = amount;
        this.order = order;
    }
}
