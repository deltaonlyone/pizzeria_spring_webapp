package com.lpnu.spring.pizzeria_spring_webapp.dto;

import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
    private final List<CartItemDTO> cartItems = new ArrayList<>();

    public void addItem(CartItemDTO cartItem){
        cartItems.add(cartItem);
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }
}
