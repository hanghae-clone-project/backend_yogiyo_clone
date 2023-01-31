package com.yogiyo.clone.domain.order.service;

import com.yogiyo.clone.domain.order.dto.OrderRequestDto;
import com.yogiyo.clone.domain.order.entity.Order;
import com.yogiyo.clone.domain.order.entity.OrderItem;
import com.yogiyo.clone.domain.order.repository.OrderRepository;
import com.yogiyo.clone.domain.store.repository.StoreRepository;
import com.yogiyo.clone.domain.temporary_admin.entity.Menu;
import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import com.yogiyo.clone.domain.temporary_admin.repository.AdminApiMenuRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final StoreRepository storeRepository;
    private final OrderRepository orderRepository;
    private final AdminApiMenuRepository menuRepository;

    @Transactional
    public String order(Long storeId, OrderRequestDto storeMenu) {
        //주문 생성
        Order order = Order.createOrder();
        storeMenu.getStoreMenu().forEach(
                m -> {
                    Menu foundMenu = menuRepository.findById(m.getId()).orElseThrow(
                            ()-> new IllegalArgumentException("해당 메뉴는 없습니다.")
                    );
                    OrderItem orderItem = new OrderItem(foundMenu, m.getPrice(), m.getAmount(), order);
                    order.addOrderItem(orderItem);
                }
        );
        orderRepository.save(order);
        Store foundStore = storeRepository.findById(storeId).orElseThrow(
                () -> new IllegalArgumentException("해당 가게는 없습니다."));
        return foundStore.getStoreName();
    }
}
