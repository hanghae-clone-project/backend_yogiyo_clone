package com.yogiyo.clone.domain.order.repository;

import com.yogiyo.clone.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
