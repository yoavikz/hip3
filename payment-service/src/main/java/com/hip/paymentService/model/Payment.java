package com.hip.paymentService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NonNull;

@Document(collection = "payment")
public class Payment {
	@Id
	private @NonNull String id;
	private @NonNull String userId;
	private @NonNull String ammount;
	private @NonNull boolean detectedAsFraud;

	// Export it to some annotation or other implementation
	private static int idGenerator = 0;

	// Private empty constructor
	@SuppressWarnings("unused")
	private Payment() {

	}

	public Payment(String userId, String ammount) {
		idGenerator++;
		this.id = String.valueOf(idGenerator);
		this.userId = userId;
		this.ammount = ammount;
		this.detectedAsFraud = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAmmount() {
		return ammount;
	}

	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}

	public boolean isDetectedAsFraud() {
		return detectedAsFraud;
	}

	public void setDetectedAsFraud(boolean detectedAsFraud) {
		this.detectedAsFraud = detectedAsFraud;
	}

}