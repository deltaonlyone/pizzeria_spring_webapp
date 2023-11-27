package com.lpnu.spring.pizzeria_spring_webapp.dto;

import com.lpnu.spring.pizzeria_spring_webapp.model.Id;

import java.util.List;

public class AddCartItemDTO {
    private Long pizzaId;
    private List<Id> additionalIngredients;
    private List<Id> ingredients;

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public List<Id> getAdditionalIngredients() {
        return additionalIngredients;
    }

    public void setAdditionalIngredients(List<Id> additionalIngredients) {
        this.additionalIngredients = additionalIngredients;
    }

    public List<Id> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Id> ingredients) {
        this.ingredients = ingredients;
    }
}
