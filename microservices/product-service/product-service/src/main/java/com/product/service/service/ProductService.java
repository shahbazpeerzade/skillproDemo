package com.product.service.service;

import com.product.service.model.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO product);  // Create a product
    ProductDTO getProductById(Long id);            // Get product by ID
    List<ProductDTO> getAllProducts();             // Get all products
    ProductDTO updateProduct(Long id, ProductDTO product); // Update product
    void deleteProduct(Long id);                   // Delete product by ID
}