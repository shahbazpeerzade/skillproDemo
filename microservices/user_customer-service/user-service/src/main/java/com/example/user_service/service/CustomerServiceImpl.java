package com.example.user_service.service;

import com.example.user_service.model.Customer;
import com.example.user_service.model.CustomerDTO;
import com.example.user_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddress(customerDTO.getAddress());
        
        Customer savedCustomer = customerRepository.save(customer);
        
        return convertToDTO(savedCustomer);
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(this::convertToDTO);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                        .map(this::convertToDTO)
                        .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setEmail(customerDTO.getEmail());
            customer.setPassword(customerDTO.getPassword());
            customer.setPhone(customerDTO.getPhone());
            customer.setAddress(customerDTO.getAddress());
            
            customerRepository.save(customer);
            return convertToDTO(customer);
        }
        return null;
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddress(customer.getAddress());
        return customerDTO;
    }
}
