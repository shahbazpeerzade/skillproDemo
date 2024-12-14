package com.example.paymentService.service;

import com.example.paymentService.PaymentStatus;
import com.example.paymentService.model.Payment;
import com.example.paymentService.model.PaymentDTO;
import java.util.List;

public interface PaymentService {


    PaymentDTO processPayment(PaymentDTO paymentDTO);
    Payment getPaymentById(Long id);
    
    List<Payment> getPaymentsByUserId(Long userId);
}
