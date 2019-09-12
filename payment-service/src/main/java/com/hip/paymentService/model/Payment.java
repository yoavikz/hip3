package com.hip.paymentService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NonNull;

@Document(collection = "payment")
public class Payment {
	@Id
	private @NonNull int id;
	private @NonNull int userId;
	private @NonNull int ammount;
	private @NonNull boolean detectedAsFraud;

	// Export it to some annotation or other implementation
	private static int idGenerator = 0;

	// Private empty constructor
	@SuppressWarnings("unused")
	private Payment() {

	}

	public Payment(int userId, int ammount) {
		idGenerator++;
		this.id = idGenerator;
		this.userId = userId;
		this.ammount = ammount;
		this.detectedAsFraud = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	public boolean isDetectedAsFraud() {
		return detectedAsFraud;
	}

	public void setDetectedAsFraud(boolean detectedAsFraud) {
		this.detectedAsFraud = detectedAsFraud;
	}

	public static int getIdGenerator() {
		return idGenerator;
	}

	public static void setIdGenerator(int idGenerator) {
		Payment.idGenerator = idGenerator;
	}
}