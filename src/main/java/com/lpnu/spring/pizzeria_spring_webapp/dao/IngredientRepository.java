package com.lpnu.spring.pizzeria_spring_webapp.dao;

import com.lpnu.spring.pizzeria_spring_webapp.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
