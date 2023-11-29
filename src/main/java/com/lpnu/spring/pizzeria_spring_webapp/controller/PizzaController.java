package com.lpnu.spring.pizzeria_spring_webapp.controller;

import com.lpnu.spring.pizzeria_spring_webapp.dto.ModifyCartItemDTO;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Ingredient;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;
import com.lpnu.spring.pizzeria_spring_webapp.model.Id;
import com.lpnu.spring.pizzeria_spring_webapp.service.IngredientService;
import com.lpnu.spring.pizzeria_spring_webapp.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("{id}")
    public String viewPizza(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Pizza pizza = pizzaService.getPizzaById(id);
        List<Id> pizzaIngredients = pizza.getIngredients().stream()
                .map(Ingredient::getId)
                .map(Id::new)
                .collect(Collectors.toList());

        ModifyCartItemDTO cartItem = new ModifyCartItemDTO();
        cartItem.setPizzaId(pizza.getId());
        cartItem.setIngredients(pizzaIngredients);
        redirectAttributes.addFlashAttribute("cartItem", cartItem);

        return "redirect:/pizzas/" + id + "/ingredients";
    }

    @GetMapping("{id}/ingredients")
    public String viewPizzaIngredients(@PathVariable Long id, @ModelAttribute("cartItem") ModifyCartItemDTO cartItem, Model model) {
        populateAttributes(id, cartItem, model);

        return "pizza_view_ingredients";
    }

    @PostMapping("{id}/ingredients/{ingredientId}/remove")
    public String removePizzaIngredient(@PathVariable Long id, @PathVariable Long ingredientId, @ModelAttribute("cartItem") ModifyCartItemDTO cartItem, Model model) {
        cartItem.getIngredients().remove(new Id(ingredientId));
        populateAttributes(id, cartItem, model);

        return "pizza_view_ingredients";
    }

    @PostMapping("{id}/ingredients/{ingredientId}/add")
    public String addPizzaIngredient(@PathVariable Long id, @PathVariable Long ingredientId, @ModelAttribute("cartItem") ModifyCartItemDTO cartItem, Model model) {
        if (!cartItem.getIngredients().contains(new Id(ingredientId))) {
            cartItem.getIngredients().add(new Id(ingredientId));
        }
        populateAttributes(id, cartItem, model);

        return "pizza_view_ingredients";
    }

    private void populateAttributes(Long pizzaId, ModifyCartItemDTO cartItem, Model model) {
        List<Ingredient> pizzaIngredients = retrieveIngredients(cartItem.getIngredients());
        List<Ingredient> allIngredients = ingredientService.getAllIngredients();

        model.addAttribute("pizzaId", pizzaId);
        model.addAttribute("pizzaIngredients", pizzaIngredients);
        model.addAttribute("allIngredients", allIngredients);

        // add to cart
        model.addAttribute("cartItem", new ModifyCartItemDTO());
    }

    private List<Ingredient> retrieveIngredients(Collection<Id> ingredients) {
        return ingredientService.getAllIngredientsById(ingredients.stream()
                .map(Id::getId).collect(Collectors.toList()));
    }

}
