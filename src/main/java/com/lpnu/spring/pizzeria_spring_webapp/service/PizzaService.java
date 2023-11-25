package com.lpnu.spring.pizzeria_spring_webapp.service;

import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;

import java.util.List;

public interface PizzaService {
    List<Pizza> getAllPizzas();
    Pizza getPizzaById(Long pizzaId);
    void savePizza(Pizza pizza);
    void deletePizza(Long pizzaId);
}
