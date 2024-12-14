package com.example.BookingService.model;

import java.time.LocalDateTime;

public class BookingDTO {

    private String bookingId;
    private String serviceName;
    private LocalDateTime bookingDateTime;
    private String customerName;
    private String customerContact;
    private Long customerId; // Added customerId for customer reference
    private Long serviceProviderId; // Referencing the service provider by ID
    private Double price;
    private String bookingStatus;
    private String feedback;
    private Double rating;
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
        return "BookingDTO [bookingId=" + bookingId + ", serviceName=" + serviceName + ", bookingDateTime="
                + bookingDateTime + ", customerName=" + customerName + ", customerContact=" + customerContact
                + ", customerId=" + customerId + ", serviceProviderId=" + serviceProviderId + ", price=" + price
                + ", bookingStatus=" + bookingStatus + ", feedback=" + feedback + ", rating=" + rating + ", address="
                + address + "]";
    }

    public BookingDTO(String bookingId, String serviceName, LocalDateTime bookingDateTime, String customerName,
                      String customerContact, Long customerId, Long serviceProviderId, Double price,
                      String bookingStatus, String feedback, Double rating, String address) {
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

    public BookingDTO(Booking booking) {
        super();
        this.bookingId = booking.getBookingId();
        this.serviceName = booking.getServiceName();
        this.bookingDateTime = booking.getBookingDateTime();
        this.customerName = booking.getCustomerName();
        this.customerContact = booking.getCustomerContact();
        this.customerId = booking.getCustomerId(); // Map customerId from entity
        this.serviceProviderId = booking.getServiceProviderId();
        this.price = booking.getPrice();
        this.bookingStatus = booking.getBookingStatus();
        this.feedback = booking.getFeedback();
        this.rating = booking.getRating();
        this.address = booking.getAddress();
    }

    public BookingDTO() {
        super();
        // Default constructor
    }
}
