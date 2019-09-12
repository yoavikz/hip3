package com.hip.paymentService.mockedServices;

import com.hip.paymentService.model.Payment;

public class FraudDetectionService {

	public static boolean isFraud(Payment payment) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return payment.getUserId() == 7;
	}
}
