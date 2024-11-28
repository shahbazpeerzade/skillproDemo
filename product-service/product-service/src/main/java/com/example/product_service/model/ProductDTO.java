package com.example.product_service.model;

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
    private Long sellerId;
}
