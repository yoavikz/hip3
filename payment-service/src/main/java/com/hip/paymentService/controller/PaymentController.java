package com.hip.paymentService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hip.paymentService.model.Payment;
import com.hip.paymentService.repository.PaymentRepository;
import com.hip.paymentService.restservice.IPaymentRestService;
import com.hip.paymentService.restservice.PaymentRestService;

@RestController
public class PaymentController {
	@Autowired
	PaymentRepository paymentRepository;
	
	private IPaymentRestService restService;
	
	@PostConstruct
	public void post() {
		this.restService = new PaymentRestService(paymentRepository);
	}

	@GetMapping("/payments")
	public List<Payment> getPayments() {
		return restService.getAllPayments();
	}

	@GetMapping("/payment/{id}")
	public Optional<Payment> getPayment(@PathVariable String id) {
		return restService.getPaymentById(id);
	}
	
	@GetMapping("/userPayments/{userId}")
	public List<Payment> getUserPayments(@PathVariable String userId) {
		return restService.getUserPayments(userId);
	}

	@PostMapping("/payment")
	public Payment addPayment(@RequestBody Payment newPayment) {
		return restService.addPayment(newPayment);
	}
}
