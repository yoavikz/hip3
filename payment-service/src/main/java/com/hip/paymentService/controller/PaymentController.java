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
public class PaymentController
{
	@Autowired
	PaymentRepository paymentRepository;

	@GetMapping("/payments")
	public List<Payment> getPayments()
	{
		List<Payment> paymentsList = paymentRepository.findAll();
		return paymentsList;
	}

	@GetMapping("/payment/{id}")
	public Optional<Payment> getPayment(@PathVariable String id)
	{
		Optional<Payment> emp = paymentRepository.findById(id);
		return emp;
	}

//	@PutMapping("/payment/{id}")
//	public Optional<Payment> updatePayment(@RequestBody Payment newPayment, @PathVariable String id)
//	{
//		Optional<Payment> optionalEmp = employeeRepository.findById(id);
//		if (optionalEmp.isPresent()) {
//			Payment emp = optionalEmp.get();
//			emp.setFirstName(newPayment.getFirstName());
//			emp.setLastName(newPayment.getLastName());
//			emp.setEmail(newPayment.getEmail());
//			employeeRepository.save(emp);
//		}
//		return optionalEmp;
//	}

	@DeleteMapping(value = "/payment/{id}", produces = "application/json; charset=utf-8")
	public String deletePayment(@PathVariable String id) {
		Boolean result = paymentRepository.existsById(id);
		paymentRepository.deleteById(id);
		return "{ \"success\" : "+ (result ? "true" : "false") +" }";
	}

//	@PostMapping("/payment")
//	public Payment addPayment(@RequestBody Payment newPayment)
//	{
//		String id = String.valueOf(new Random().nextInt());
//		Payment emp = new Payment(id, newPayment.getFirstName(), newPayment.getLastName(), newPayment.getEmail());
//		employeeRepository.insert(emp);
//		return emp;
//	}
}
