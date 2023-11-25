package com.lpnu.spring.pizzeria_spring_webapp.dao;

import com.lpnu.spring.pizzeria_spring_webapp.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
