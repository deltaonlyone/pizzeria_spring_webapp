package com.lpnu.spring.pizzeria_spring_webapp.controller;

import com.lpnu.spring.pizzeria_spring_webapp.dto.AddCartItemDTO;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Ingredient;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Order;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;
import com.lpnu.spring.pizzeria_spring_webapp.entity.User;
import com.lpnu.spring.pizzeria_spring_webapp.model.Id;
import com.lpnu.spring.pizzeria_spring_webapp.service.IngredientService;
import com.lpnu.spring.pizzeria_spring_webapp.service.OrderService;
import com.lpnu.spring.pizzeria_spring_webapp.service.PizzaService;
import com.lpnu.spring.pizzeria_spring_webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class GeneralController {

    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/")
    public String getAllPizzas(Model model, HttpSession session) {
        // pizzas
        List<Pizza> allPizzas = pizzaService.getAllPizzas();
        model.addAttribute("allPizzas", allPizzas);

        // add to cart
        model.addAttribute("cartItem", new AddCartItemDTO());

        return "view_all_pizzas";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "view_all_users";
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<Order> allOrders = orderService.getAllOrders();
        model.addAttribute("allOrders", allOrders);
        return "view_all_orders";
    }

    @GetMapping("/ingredients")
    public String getAllIngredients(Model model) {
        List<Ingredient> allIngredients = ingredientService.getAllIngredients();
        model.addAttribute("allIngredients", allIngredients);
        return "view_all_ingredients";
    }

    @GetMapping("/pizzas/ingredients")
    public String getPizzaIngredients(@RequestParam("pizzaId") Long id, Model model) {
        Pizza pizza = pizzaService.getPizzaById(id);
        List<Ingredient> pizzaIngredients = pizza.getIngredients();

        model.addAttribute("pizzaId", pizza.getId());
        model.addAttribute("pizzaIngredients", pizzaIngredients);

        // add to cart
        model.addAttribute("cartItem", new AddCartItemDTO());

        return "view_pizza_ingredients";
    }

    @PostMapping("/pizzas/ingredients/remove")
    public String removePizzaIngredient(@RequestParam("pizzaId") Long pizzaId, @ModelAttribute("cartItem") AddCartItemDTO addCartItem, Model model) {
        List<Ingredient> pizzaIngredients = ingredientService.getAllIngredientsById(addCartItem.getIngredients()
                .stream().map(Id::getId).collect(Collectors.toList()));

        model.addAttribute("pizzaId", pizzaId);
        model.addAttribute("pizzaIngredients", pizzaIngredients);

        // add to cart
        model.addAttribute("cartItem", new AddCartItemDTO());

        return "view_pizza_ingredients";
    }

}
