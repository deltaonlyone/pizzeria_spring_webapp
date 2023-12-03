package com.lpnu.spring.pizzeria_spring_webapp.service;

import com.lpnu.spring.pizzeria_spring_webapp.dao.OrderRepository;
import com.lpnu.spring.pizzeria_spring_webapp.entity.Order;
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
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void testGetAllOrders() {
        List<Order> orderList = Arrays.asList(new Order(), new Order(), new Order());
        when(orderRepository.findAll()).thenReturn(orderList);

        List<Order> result = orderService.getAllOrders();

        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void testGetOrderById() {
        Long orderId = 1L;
        Order order = new Order();
        when(orderRepository.getReferenceById(orderId)).thenReturn(order);

        Order result = orderService.getOrderById(orderId);

        Assertions.assertEquals(order, result);
    }

    @Test
    public void testSaveOrder() {
        Order order = new Order();

        orderService.saveOrder(order);

        verify(orderRepository).save(order);
    }

    @Test
    public void testDeleteOrder() {
        Long orderId = 1L;

        orderService.deleteOrder(orderId);

        verify(orderRepository).deleteById(orderId);
    }
}
