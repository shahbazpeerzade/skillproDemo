package com.example.paymentService.external;

;
import com.example.user_service.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8082")  // Adjust the URL if needed.
public interface UserServiceClient {

    @GetMapping("/api/customers/{userId}")
    Customer getUserById(@PathVariable("userId") Long userId);
}
