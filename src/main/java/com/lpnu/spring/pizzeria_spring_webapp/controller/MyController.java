package com.lpnu.spring.pizzeria_spring_webapp.controller;

import com.lpnu.spring.pizzeria_spring_webapp.entity.Order;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Pizza;
import com.lpnu.spring.pizzeria_spring_webapp.entity.User;
import com.lpnu.spring.pizzeria_spring_webapp.service.OrderService;
import com.lpnu.spring.pizzeria_spring_webapp.service.PizzaService;
import com.lpnu.spring.pizzeria_spring_webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {

    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String getAllPizzas(Model model) {
        List<Pizza> allPizzas = pizzaService.getAllPizzas();
        model.addAttribute("allPizzas", allPizzas);
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
}
