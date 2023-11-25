package com.lpnu.spring.pizzeria_spring_webapp.dao;

import com.lpnu.spring.pizzeria_spring_webapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
