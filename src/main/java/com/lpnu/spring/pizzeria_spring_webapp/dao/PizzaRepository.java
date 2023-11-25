package com.lpnu.spring.pizzeria_spring_webapp.dao;

import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {
}
