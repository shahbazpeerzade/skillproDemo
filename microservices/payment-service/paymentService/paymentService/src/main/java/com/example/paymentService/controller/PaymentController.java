package com.example.paymentService.controller;

import com.example.paymentService.model.Payment;
import com.example.paymentService.model.PaymentDTO;
import com.example.paymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Process payment
    @PostMapping("/create")
    public PaymentDTO createPayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.processPayment(paymentDTO);
    }

    // Get payment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return payment != null ? 
            new ResponseEntity<>(payment, HttpStatus.OK) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get payments by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payment>> getPaymentsByUserId(@PathVariable Long userId) {
        List<Payment> payments = paymentService.getPaymentsByUserId(userId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
}
