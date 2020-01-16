package com.pstomi.gametransaction.model;

import java.util.UUID;

public class GameTransactionModel {

	private final String transactionId;
	private final String userId;
	private final String productId;
	private final int monetaryAmount;
	
	
	public GameTransactionModel(String userId, String productId, int monetaryAmount) {
		super();
		this.transactionId = UUID.randomUUID().toString();
		this.userId = userId;
		this.productId = productId;
		this.monetaryAmount = monetaryAmount;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public String getUserId() {
		return userId;
	}


	public String getProductId() {
		return productId;
	}


	public int getMonetaryAmount() {
		return monetaryAmount;
	}
}
