package com.lpnu.spring.pizzeria_spring_webapp.service;

import com.lpnu.spring.pizzeria_spring_webapp.dao.OrderItemRepository;
import com.lpnu.spring.pizzeria_spring_webapp.entity.OrderItem;
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
public class OrderItemServiceImplTest {

    @Mock
    private OrderItemRepository orderItemRepository;

    @InjectMocks
    private OrderItemServiceImpl orderItemService;

    @Test
    public void testGetAllOrderItems() {
        List<OrderItem> orderItemList = Arrays.asList(new OrderItem(), new OrderItem(), new OrderItem());
        when(orderItemRepository.findAll()).thenReturn(orderItemList);

        List<OrderItem> result = orderItemService.getAllOrderItems();

        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void testGetOrderItemById() {
        Long orderItemId = 1L;
        OrderItem orderItem = new OrderItem();
        when(orderItemRepository.getReferenceById(orderItemId)).thenReturn(orderItem);

        OrderItem result = orderItemService.getOrderItemById(orderItemId);

        Assertions.assertEquals(orderItem, result);
    }

    @Test
    public void testSaveOrderItem() {
        OrderItem orderItem = new OrderItem();

        orderItemService.saveOrderItem(orderItem);

        verify(orderItemRepository).save(orderItem);
    }

    @Test
    public void testDeleteOrderItem() {
        Long orderItemId = 1L;

        orderItemService.deleteOrderItem(orderItemId);

        verify(orderItemRepository).deleteById(orderItemId);
    }
}
