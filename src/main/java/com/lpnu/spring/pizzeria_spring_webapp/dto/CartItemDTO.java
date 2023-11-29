package com.lpnu.spring.pizzeria_spring_webapp.dto;

import com.lpnu.spring.pizzeria_spring_webapp.entity.Ingredient;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;

import java.util.List;

public class CartItemDTO {
    private Pizza pizza;
    private List<Ingredient> ingredients;
    private int quantity;
    private double price;

    public CartItemDTO(Pizza pizza, List<Ingredient> ingredients, double price) {
        this.quantity = 1;
        this.pizza = pizza;
        this.ingredients = ingredients;
        this.price = price;
    }
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
