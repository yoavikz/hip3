package com.hip.paymentService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hip.paymentService.model.Payment;
import com.hip.paymentService.repository.PaymentRepository;

@RestController
public class PaymentController {
	@Autowired
	PaymentRepository paymentRepository;

	@GetMapping("/payments")
	public List<Payment> getPayments() {
		List<Payment> paymentsList = paymentRepository.findAll();
		return paymentsList;
	}

	@GetMapping("/payment/{id}")
	public Optional<Payment> getPayment(@PathVariable String id) {
		Optional<Payment> pay = paymentRepository.findById(id);
		return pay;
	}

	@DeleteMapping(value = "/payment/{id}", produces = "application/json; charset=utf-8")
	public String deletePayment(@PathVariable String id) {
		Boolean result = paymentRepository.existsById(id);
		paymentRepository.deleteById(id);
		return "{ \"success\" : " + (result ? "true" : "false") + " }";
	}

	@PostMapping("/payment")
	public Payment addPayment(@RequestBody Payment newPayment) {
		String id = String.valueOf(new Random().nextInt());
		Payment pay = new Payment(newPayment.getUserId(), newPayment.getAmmount());
		paymentRepository.insert(pay);
		return pay;
	}
}
