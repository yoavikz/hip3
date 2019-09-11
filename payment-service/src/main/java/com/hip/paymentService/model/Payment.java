package com.hip.paymentService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@Document(collection = "payment")
public class Payment {
	@Id 
	private @NonNull String id;
	private @NonNull String userId;
	private @NonNull int ammount;
	private @NonNull boolean detectedAsFraud;
}