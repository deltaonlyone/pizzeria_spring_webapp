package com.lpnu.spring.pizzeria_spring_webapp.service;

import com.lpnu.spring.pizzeria_spring_webapp.dao.PizzaRepository;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PizzaServiceImplTest {

    @Mock
    private PizzaRepository pizzaRepository;

    @InjectMocks
    private PizzaServiceImpl pizzaService;

    @Test
    public void testGetAllPizzas() {
        List<Pizza> pizzaList = Arrays.asList(new Pizza(), new Pizza(), new Pizza());
        when(pizzaRepository.findAll()).thenReturn(pizzaList);

        List<Pizza> result = pizzaService.getAllPizzas();

        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void testGetPizzaById() {
        Long pizzaId = 1L;
        Pizza pizza = new Pizza();
        when(pizzaRepository.getReferenceById(pizzaId)).thenReturn(pizza);

        Pizza result = pizzaService.getPizzaById(pizzaId);

        Assertions.assertEquals(pizza, result);
    }

    @Test
    public void testSavePizza() {
        Pizza pizza = new Pizza();

        pizzaService.savePizza(pizza);

        verify(pizzaRepository).save(pizza);
    }

    @Test
    public void testDeletePizza() {
        Long pizzaId = 1L;

        pizzaService.deletePizza(pizzaId);

        verify(pizzaRepository).deleteById(pizzaId);
    }
}
