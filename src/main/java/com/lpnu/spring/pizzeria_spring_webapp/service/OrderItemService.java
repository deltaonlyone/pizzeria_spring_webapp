package com.lpnu.spring.pizzeria_spring_webapp.service;

import com.lpnu.spring.pizzeria_spring_webapp.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();
    OrderItem getOrderItemById(Long orderItemId);
    void saveOrderItem(OrderItem orderItem);
    void deleteOrderItem(Long orderItemId);
}
