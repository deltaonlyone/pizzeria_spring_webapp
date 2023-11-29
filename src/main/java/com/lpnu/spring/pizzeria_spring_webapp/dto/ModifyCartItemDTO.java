package com.lpnu.spring.pizzeria_spring_webapp.dto;

import com.lpnu.spring.pizzeria_spring_webapp.model.Id;

import java.util.ArrayList;
import java.util.List;

public class ModifyCartItemDTO {
    private Long pizzaId;
    private List<Id> ingredients;

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public List<Id> getIngredients() {
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }
        return ingredients;
    }

    public void setIngredients(List<Id> ingredients) {
        this.ingredients = ingredients;
    }
}
