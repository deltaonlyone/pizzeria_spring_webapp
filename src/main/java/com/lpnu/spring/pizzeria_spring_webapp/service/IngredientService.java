package com.lpnu.spring.pizzeria_spring_webapp.service;

import com.lpnu.spring.pizzeria_spring_webapp.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredients();

    Ingredient getIngredientById(Long ingredientId);

    List<Ingredient> getAllIngredientsById(List<Long> ids);

    void saveIngredient(Ingredient ingredient);

    void deleteIngredient(Long ingredientId);
}
