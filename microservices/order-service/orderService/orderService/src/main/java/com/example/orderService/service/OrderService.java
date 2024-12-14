package com.example.orderService.service;

import com.example.orderService.OrderStatus;
import com.example.orderService.model.Order;
import com.example.orderService.model.OrderDTO;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderDTO orderDTO);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    List<Order> getOrdersByUserId(Long userId);

    Order updateOrder(Long id, OrderDTO orderDTO);

    Order updateOrderStatus(Long orderId, OrderStatus status);

    void deleteOrder(Long id);
}
