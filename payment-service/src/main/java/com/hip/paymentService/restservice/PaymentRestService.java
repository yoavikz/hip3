package com.hip.paymentService.restservice;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hip.paymentService.mockedServices.FraudDetectionService;
import com.hip.paymentService.model.Payment;
import com.hip.paymentService.repository.PaymentRepository;

public class PaymentRestService implements IPaymentRestService {

	private PaymentRepository paymentRepository;

	public PaymentRestService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> paymentsList = paymentRepository.findAll();
		return paymentsList;
	}

	@Override
	public Optional<Payment> getPaymentById(@PathVariable String id) {
		Optional<Payment> pay = paymentRepository.findById(id);
		return pay;
	}

	@Override
	public Payment addPayment(@RequestBody Payment newPayment) {
		Payment pay = new Payment(newPayment.getUserId(), newPayment.getAmmount());
		pay.setDetectedAsFraud(FraudDetectionService.isFraud(pay));
		paymentRepository.insert(pay);
		return pay;
	}

	@Override
	public List<Payment> getUserPayments(String userId) {
		List<Payment> paymentsList = paymentRepository.findByUserId(userId);
		return paymentsList;
	}
}
