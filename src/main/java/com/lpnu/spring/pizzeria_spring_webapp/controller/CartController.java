package com.lpnu.spring.pizzeria_spring_webapp.controller;

import com.lpnu.spring.pizzeria_spring_webapp.dto.AddCartItemDTO;
import com.lpnu.spring.pizzeria_spring_webapp.dto.CartDTO;
import com.lpnu.spring.pizzeria_spring_webapp.dto.CartItemDTO;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Ingredient;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;
import com.lpnu.spring.pizzeria_spring_webapp.model.Id;
import com.lpnu.spring.pizzeria_spring_webapp.service.IngredientService;
import com.lpnu.spring.pizzeria_spring_webapp.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    public PizzaService pizzaService;
    @Autowired
    public IngredientService ingredientService;

    @GetMapping
    public String viewCart() {
        return "view_cart";
    }

    @PostMapping
    public String addToCart(@ModelAttribute("cartItem") AddCartItemDTO addCartItem, HttpSession session) {
        Pizza pizza = pizzaService.getPizzaById(addCartItem.getPizzaId());
        double price = pizza.getPrice();

        List<Ingredient> ingredients = null;
        if (addCartItem.getIngredients() != null) {
            ingredients = ingredientService.getAllIngredientsById(addCartItem.getIngredients()
                    .stream().map(Id::getId).collect(Collectors.toList()));
        }

        List<Ingredient> additionalIngredients = null;
        if (addCartItem.getAdditionalIngredients() != null) {
            additionalIngredients = ingredientService.getAllIngredientsById(addCartItem.getAdditionalIngredients()
                    .stream().map(Id::getId).collect(Collectors.toList()));
            double additionalPrice = additionalIngredients.stream()
                    .map(Ingredient::getPrice)
                    .reduce(Double::sum).orElse(0.0);
            price += additionalPrice;
        }

        CartDTO cart = (CartDTO) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartDTO();
        }

        cart.addItem(new CartItemDTO(pizza, ingredients, additionalIngredients, price));
        session.setAttribute("cart", cart);

        return "redirect:/";
    }
}
