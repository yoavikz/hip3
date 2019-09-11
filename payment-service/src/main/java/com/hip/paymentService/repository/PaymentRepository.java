package com.hip.paymentService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hip.paymentService.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
