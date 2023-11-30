package com.lpnu.spring.pizzeria_spring_webapp.service;

import com.lpnu.spring.pizzeria_spring_webapp.dao.PizzaRepository;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    @Cacheable("allPizzas")
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getPizzaById(Long pizzaId) {
        return pizzaRepository.getReferenceById(pizzaId);
    }

    @Override
    public void savePizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    @Override
    public void deletePizza(Long pizzaId) {
        pizzaRepository.deleteById(pizzaId);
    }
}
