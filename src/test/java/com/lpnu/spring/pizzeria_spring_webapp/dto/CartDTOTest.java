package com.lpnu.spring.pizzeria_spring_webapp.dto;

import com.lpnu.spring.pizzeria_spring_webapp.entity.Ingredient;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartDTOTest {

    @Test
    public void testAddItemToCart() {
        CartDTO cart = new CartDTO();
        Pizza pizza = new Pizza();
        List<Ingredient> ingredients = Arrays.asList(new Ingredient(), new Ingredient());

        CartItemDTO cartItem = new CartItemDTO(pizza, ingredients, 10.0);
        cart.addItem(cartItem);

        assertEquals(1, cart.getCartItems().size());
        assertEquals(cartItem, cart.getCartItems().get(0));
    }

    @Test
    public void testCountTotalAmount() {
        CartDTO cart = new CartDTO();
        Pizza pizza1 = new Pizza();
        List<Ingredient> ingredients1 = Arrays.asList(new Ingredient(), new Ingredient());
        CartItemDTO cartItem1 = new CartItemDTO(pizza1, ingredients1, 10.0);

        Pizza pizza2 = new Pizza();
        List<Ingredient> ingredients2 = Arrays.asList(new Ingredient(), new Ingredient());
        CartItemDTO cartItem2 = new CartItemDTO(pizza2, ingredients2, 15.0);

        cart.addItem(cartItem1);
        cart.addItem(cartItem2);

        double expectedTotalAmount = 25.0;
        assertEquals(expectedTotalAmount, cart.countTotalAmount());
    }
}
