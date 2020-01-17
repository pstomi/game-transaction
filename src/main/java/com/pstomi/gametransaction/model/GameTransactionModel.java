package com.pstomi.gametransaction.model;

import java.util.UUID;

public class GameTransactionModel {

	private final String transactionId;
	private String userId;
	private String productId;
	private int monetaryAmount;
	
	public GameTransactionModel() {
		this.transactionId = UUID.randomUUID().toString();
	}
	
	public GameTransactionModel(final String userId, final String productId, final int monetaryAmount) {
		super();
		this.transactionId = UUID.randomUUID().toString();
		this.userId = userId;
		this.productId = productId;
		this.monetaryAmount = monetaryAmount;
	}
	
	public GameTransactionModel(final String transactionId, final String userId, final String productId, final int monetaryAmount) {
		super();
		this.transactionId = transactionId;
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

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getMonetaryAmount() {
		return monetaryAmount;
	}

	public void setMonetaryAmount(int monetaryAmount) {
		this.monetaryAmount = monetaryAmount;
	}

}
