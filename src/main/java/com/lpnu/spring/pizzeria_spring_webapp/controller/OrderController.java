package com.lpnu.spring.pizzeria_spring_webapp.controller;

import com.lpnu.spring.pizzeria_spring_webapp.dto.CartDTO;
import com.lpnu.spring.pizzeria_spring_webapp.dto.CartItemDTO;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Order;
import com.lpnu.spring.pizzeria_spring_webapp.entity.OrderItem;
import com.lpnu.spring.pizzeria_spring_webapp.service.OrderItemService;
import com.lpnu.spring.pizzeria_spring_webapp.service.OrderService;
import com.lpnu.spring.pizzeria_spring_webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private UserService userService;

    @PostMapping
    public String createOrder(HttpSession httpSession){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getName();
        String username = authentication.getName();
        CartDTO cart = (CartDTO) httpSession.getAttribute("cart");
        Order order = new Order();
        order.setUser(userService.getUserByUsername(username));
        order.setStatus("NEW");
        order.setTotalAmount(cart.countTotalAmount());
        order.setDateTime(new Date());
        orderService.saveOrder(order);
        for (CartItemDTO cartItem : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);

            orderItem.setPizza(cartItem.getPizza());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setUnitPrice(cartItem.getPrice() / cartItem.getQuantity());

            orderItemService.saveOrderItem(orderItem);
        }
        httpSession.setAttribute("cart", null);
        return "redirect:/";
    }

    @GetMapping
    public String getAllOrders(Model model) {
        List<Order> allOrders = orderService.getAllOrders();
        model.addAttribute("allOrders", allOrders);
        return "view_all_orders";
    }

}
