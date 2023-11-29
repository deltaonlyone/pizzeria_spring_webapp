package com.lpnu.spring.pizzeria_spring_webapp.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CartDTO {
    private final List<CartItemDTO> cartItems = new ArrayList<>();

    public void addItem(CartItemDTO cartItem) {
        cartItems.add(cartItem);
    }

    public Double countTotalAmount() {
        AtomicReference<Double> totalAmount = new AtomicReference<>((double) 0);
        cartItems.forEach(cartItem -> {
            totalAmount.updateAndGet(v -> v + (cartItem.getPrice()));
        });
        return totalAmount.get();
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }
}
