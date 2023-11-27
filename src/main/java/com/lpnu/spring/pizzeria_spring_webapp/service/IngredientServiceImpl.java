package com.lpnu.spring.pizzeria_spring_webapp.service;

import com.lpnu.spring.pizzeria_spring_webapp.dao.IngredientRepository;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();

    }

    @Override
    public List<Ingredient> getAllIngredientsById(List<Long> ids) {
        return ingredientRepository.findAllById(ids);

    }

    @Override
    public Ingredient getIngredientById(Long ingredientId) {
        return ingredientRepository.getReferenceById(ingredientId);
    }

    @Override
    public void saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(Long ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }
}
