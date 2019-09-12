package com.hip.paymentService.restservice;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.hip.paymentService.model.Payment;

public interface IPaymentRestService {

	public List<Payment> getAllPayments();
	
	public Optional<Payment> getPaymentById(String id);
	
	public Payment addPayment(Payment payment);

	public List<Payment> getUserPayments(String userId);
	
}
