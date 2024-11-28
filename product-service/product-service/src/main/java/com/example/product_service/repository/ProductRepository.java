package com.example.product_service.repository;


import com.example.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods if needed
    Product findBySku(String sku);
}
