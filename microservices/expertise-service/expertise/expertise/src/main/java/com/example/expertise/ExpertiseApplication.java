package com.example.expertise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExpertiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpertiseApplication.class, args);
	}

}
