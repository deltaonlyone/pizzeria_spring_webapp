package com.lpnu.spring.pizzeria_spring_webapp.service;

import com.lpnu.spring.pizzeria_spring_webapp.dao.IngredientRepository;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Ingredient;
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
public class IngredientServiceImplTest {

    @Mock
    private IngredientRepository ingredientRepository;

    @InjectMocks
    private IngredientServiceImpl ingredientService;

    @Test
    public void testGetAllIngredients() {
        List<Ingredient> ingredientList = Arrays.asList(new Ingredient(), new Ingredient(), new Ingredient());
        when(ingredientRepository.findAll()).thenReturn(ingredientList);

        List<Ingredient> result = ingredientService.getAllIngredients();

        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void testGetAllIngredientsById() {
        List<Long> ingredientIds = Arrays.asList(1L, 2L, 3L);
        List<Ingredient> ingredientList = Arrays.asList(new Ingredient(), new Ingredient(), new Ingredient());
        when(ingredientRepository.findAllById(ingredientIds)).thenReturn(ingredientList);

        List<Ingredient> result = ingredientService.getAllIngredientsById(ingredientIds);

        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void testGetIngredientById() {
        Long ingredientId = 1L;
        Ingredient ingredient = new Ingredient();
        when(ingredientRepository.getReferenceById(ingredientId)).thenReturn(ingredient);

        Ingredient result = ingredientService.getIngredientById(ingredientId);

        Assertions.assertEquals(ingredient, result);
    }

    @Test
    public void testSaveIngredient() {
        Ingredient ingredient = new Ingredient();

        ingredientService.saveIngredient(ingredient);

        verify(ingredientRepository).save(ingredient);
    }

    @Test
    public void testDeleteIngredient() {
        Long ingredientId = 1L;

        ingredientService.deleteIngredient(ingredientId);

        verify(ingredientRepository).deleteById(ingredientId);
    }
}
