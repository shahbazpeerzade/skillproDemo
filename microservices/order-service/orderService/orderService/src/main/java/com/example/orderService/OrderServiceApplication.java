package com.example.orderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OrderServiceApplication {
	public static OrderStatus fromString(String status) {
		try {
			return OrderStatus.valueOf(status);
		} catch (IllegalArgumentException e) {
			return OrderStatus.PENDING; // Default to PENDING if invalid status is provided
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
