package com.example.orderService;

public enum OrderStatus {
    PENDING,      // Order has been placed but not yet processed
    CONFIRMED,    // Order has been confirmed by the system or admin
    SHIPPED,      // Order has been dispatched to the user
    DELIVERED,    // Order has been delivered to the user
    CANCELLED,    // Order has been cancelled
    RETURNED,     // Order has been returned
    PROCESSING;   // New enum constant for "PROCESSING" status

    public static OrderStatus fromString(String status) {
        try {
            return OrderStatus.valueOf(status.toUpperCase());  // Convert to uppercase to match enum constants
        } catch (IllegalArgumentException e) {
            return null;  // or default to a valid status, e.g., PENDING
        }
    }

}
