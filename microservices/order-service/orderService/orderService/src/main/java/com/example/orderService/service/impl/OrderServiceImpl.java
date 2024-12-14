package com.example.orderService.service.impl;

import com.example.orderService.OrderStatus;
import com.example.orderService.model.Order;
import com.example.orderService.model.OrderDTO;
import com.example.orderService.repository.OrderRepository;
import com.example.orderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        logger.info("Creating order for user: {} with product ID: {} and quantity: {}",
                orderDTO.getUserId(), orderDTO.getProductId(), orderDTO.getQuantity());

        Order order = new Order();
        order.setProductId(orderDTO.getProductId());
        order.setUserId(orderDTO.getUserId());
        order.setQuantity(orderDTO.getQuantity());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setStatus(OrderStatus.PENDING);
        order.setOrderDate(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);
        logger.info("Order created successfully with ID: {}", savedOrder.getId());
        return savedOrder;
    }

    @Override
    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        logger.info("Updating order ID: {} with status: {}", orderId, status);

        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(status);
            Order updatedOrder = orderRepository.save(order);
            logger.info("Order ID. : {} status updated to: {}", orderId, status);
            return updatedOrder;
        } else {
            logger.error("Order not found with ID: {}", orderId);
            throw new RuntimeException("Order not found");
        }
    }

    @Override
    public Order getOrderById(Long id) {
        logger.info("Fetching order by ID: {}", id);

        try {
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
            logger.info("Order found with ID: {}", id);
            return order;
        } catch (Exception e) {
            logger.error("Error fetching order with ID: {}: {}", id, e.getMessage());
            throw new RuntimeException("Error fetching order with id: " + id, e);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        logger.info("Fetching all orders");

        try {
            List<Order> orders = orderRepository.findAll();
            logger.info("Fetched {} orders", orders.size());
            return orders;
        } catch (Exception e) {
            logger.error("Error fetching all orders: {}", e.getMessage());
            throw new RuntimeException("Error fetching all orders", e);
        }
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        logger.info("Fetching orders for user ID: {}", userId);
        List<Order> orders = orderRepository.findByUserId(userId);
        logger.info("Fetched {} orders for user ID: {}", orders.size(), userId);
        return orders;
    }

    @Override
    public Order updateOrder(Long id, OrderDTO orderDTO) {
        logger.info("Updating order ID: {}", id);

        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setProductId(orderDTO.getProductId());
            order.setUserId(orderDTO.getUserId());
            order.setQuantity(orderDTO.getQuantity());
            order.setTotalPrice(orderDTO.getTotalPrice());
            Order updatedOrder = orderRepository.save(order);
            logger.info("Order ID: {} updated successfully", id);
            return updatedOrder;
        } else {
            logger.error("Order not found with ID: {}", id);
            throw new RuntimeException("Order not found");
        }
    }

    @Override
    public void deleteOrder(Long id) {
        logger.info("Deleting order ID: {}", id);

        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            logger.info("Order ID: {} deleted successfully", id);
        } else {
            logger.error("Order not found with ID: {}", id);
            throw new RuntimeException("Order not found");
        }
    }
}
