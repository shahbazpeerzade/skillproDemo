package com.example.paymentService.external;

import com.example.orderService.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://localhost:8091/api/orders")
public interface OrderServiceClient {
    @GetMapping("/{id}")
    Order getOrderById(@PathVariable Long id);
}
