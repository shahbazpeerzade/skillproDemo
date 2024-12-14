package com.product.service.model;

import com.example.user_service.model.Customer;

import com.productCategory.service.module.CategoryDto;
import lombok.Data;

@Data
public class ProductDTO {
        private Long id;
        private String name;
        private String sku;
        private Double price;
        private String description;
        private Integer quantity;
        private String imageUrl;
        private Long categoryId;
        private Long customerId;

        public ProductDTO(Long id, String name, String sku, Double price, String description, Integer quantity, String imageUrl, Long categoryId) {
        }

        public ProductDTO() {

        }

        // Getters and Setters
}

