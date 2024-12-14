package com.example.user_service.repository;

import com.example.user_service.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Add custom queries if needed
    Customer findByEmail(String email);
}
