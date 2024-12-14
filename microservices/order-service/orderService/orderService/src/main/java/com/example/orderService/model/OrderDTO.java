package com.example.orderService.model;

public class OrderDTO {

    private Long productId;
    private Long userId;
    private int quantity;
    private double totalPrice;

    // Constructors
    public OrderDTO() {
    }

    public OrderDTO(Long productId, Long userId, int quantity, double totalPrice) {
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


}
