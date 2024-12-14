package com.example.paymentService.service.impl;



import com.example.orderService.model.Order;
import com.example.paymentService.PaymentStatus;
import com.example.paymentService.external.OrderServiceClient;
import com.example.paymentService.external.UserServiceClient;
import com.example.paymentService.model.Payment;
import com.example.paymentService.model.PaymentDTO;
import com.example.paymentService.repository.PaymentRepository;
import com.example.paymentService.service.PaymentService;
import com.example.user_service.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private OrderServiceClient orderServiceClient;

    @Override
    public PaymentDTO processPayment(PaymentDTO paymentDTO) {
        // Validate user ID using Feign Client
        Customer customer = userServiceClient.getUserById(paymentDTO.getUserId());
        if (customer == null) {
            throw new RuntimeException("User not found with ID: " + paymentDTO.getUserId());
        }

        // Validate order ID using Feign Client
        Order order = orderServiceClient.getOrderById(paymentDTO.getOrderId());
        if (order == null) {
            throw new RuntimeException("Order not found with ID: " + paymentDTO.getOrderId());
        }

        // Map PaymentDTO to Payment entity
        Payment payment = new Payment();
        payment.setUserId(paymentDTO.getUserId());
        payment.setOrderId(paymentDTO.getOrderId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setStatus(paymentDTO.getStatus() != null ? paymentDTO.getStatus() : PaymentStatus.PENDING);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setTransactionId(paymentDTO.getTransactionId());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setPaymentGateway(paymentDTO.getPaymentGateway());
        payment.setConfirmationDate(paymentDTO.getConfirmationDate());
        payment.setRemarks(paymentDTO.getRemarks());

        // Save the payment entity to the database
        payment = paymentRepository.save(payment);

        // Map the saved Payment entity back to PaymentDTO
        PaymentDTO savedPaymentDTO = mapToDTO(payment);
        return savedPaymentDTO;
    }

    private PaymentDTO mapToDTO(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(payment.getId());
        paymentDTO.setUserId(payment.getUserId());
        paymentDTO.setOrderId(payment.getOrderId());
        paymentDTO.setAmount(payment.getAmount());
        paymentDTO.setStatus(payment.getStatus());
        paymentDTO.setPaymentDate(payment.getPaymentDate());
        paymentDTO.setTransactionId(payment.getTransactionId());
        paymentDTO.setPaymentMethod(payment.getPaymentMethod());
        paymentDTO.setPaymentGateway(payment.getPaymentGateway());
        paymentDTO.setConfirmationDate(payment.getConfirmationDate());
        paymentDTO.setRemarks(payment.getRemarks());
        return paymentDTO;
    }
    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getPaymentsByUserId(Long userId) {
        return paymentRepository.findByUserId(userId);
    }
}




