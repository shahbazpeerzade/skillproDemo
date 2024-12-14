package com.example.BookingService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {

    @Id
    private String bookingId;
    @Column(nullable = false)
    private String serviceName;
    @Column(nullable = false)
    private LocalDateTime bookingDateTime;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String customerContact;
    @Column(nullable = false)
    private Long customerId; 
    @Column(nullable = false)
    private Long serviceProviderId; 
    @Column(nullable = false)
    private Double price;
    private String bookingStatus;
    private String feedback;
    private Double rating;
    @Column(nullable = false)
    private String address;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(Long serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", serviceName=" + serviceName + ", bookingDateTime="
                + bookingDateTime + ", customerName=" + customerName + ", customerContact=" + customerContact
                + ", customerId=" + customerId + ", serviceProviderId=" + serviceProviderId + ", price=" + price
                + ", bookingStatus=" + bookingStatus + ", feedback=" + feedback + ", rating=" + rating + ", address="
                + address + "]";
    }

    public Booking() {
        super();
        // Default constructor
    }

    public Booking(String bookingId, String serviceName, LocalDateTime bookingDateTime, String customerName,
            String customerContact, Long customerId, Long serviceProviderId, Double price, String bookingStatus,
            String feedback, Double rating, String address) {
        super();
        this.bookingId = bookingId;
        this.serviceName = serviceName;
        this.bookingDateTime = bookingDateTime;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.customerId = customerId;
        this.serviceProviderId = serviceProviderId;
        this.price = price;
        this.bookingStatus = bookingStatus;
        this.feedback = feedback;
        this.rating = rating;
        this.address = address;
    }

    public Booking(BookingDTO bookingDTO) {
        super();
        this.bookingId = bookingDTO.getBookingId();
        this.serviceName = bookingDTO.getServiceName();
        this.bookingDateTime = bookingDTO.getBookingDateTime();
        this.customerName = bookingDTO.getCustomerName();
        this.customerContact = bookingDTO.getCustomerContact();
        this.customerId = bookingDTO.getCustomerId(); // Map customerId from DTO
        this.serviceProviderId = bookingDTO.getServiceProviderId();
        this.price = bookingDTO.getPrice();
        this.bookingStatus = bookingDTO.getBookingStatus();
        this.feedback = bookingDTO.getFeedback();
        this.rating = bookingDTO.getRating();
        this.address = bookingDTO.getAddress();
    }
}
