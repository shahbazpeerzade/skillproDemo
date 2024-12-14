package com.example.user_service.service;

import com.example.user_service.model.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    
    Optional<CustomerDTO> getCustomerById(Long id);
    
    List<CustomerDTO> getAllCustomers();
    
    void deleteCustomer(Long id);
    
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
}
