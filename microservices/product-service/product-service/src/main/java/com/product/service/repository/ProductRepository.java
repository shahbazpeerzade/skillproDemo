package com.product.service.repository;


import com.product.service.model.Product;


import com.product.service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query method to find a product by SKU
    Product findBySku(String sku);
}

