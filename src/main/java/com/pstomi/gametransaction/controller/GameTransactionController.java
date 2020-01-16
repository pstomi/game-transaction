package com.pstomi.gametransaction.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.pstomi.gametransaction.model.GameTransactionModel;

@Controller
public class GameTransactionController {
	
	private static final Logger logger = LogManager.getLogger(GameTransactionController.class);
	
	private final Map<String, GameTransactionModel> storage;
    
    public GameTransactionController()  { 
    	storage = new HashMap<String, GameTransactionModel>();
    }
	
	/**
	 * Add Game transaction to storage
	 * 
	 * @param transaction the game transaction
	 * @return true if transaction has been stored
	 */
	public boolean addGameTransaction(GameTransactionModel transaction) {
		storage.put(transaction.getTransactionId(), transaction);
		boolean transactionStored = storage.containsKey(transaction.getTransactionId());
		if(transactionStored) {
			logger.info("{} transaction has been stored successfully.", transaction.getTransactionId());
		} else {
			logger.error("{} transaction can not be stored.", transaction.getTransactionId());
		}
		return transactionStored;
	}
	
	/**
	 * Get one Game transaction by id
	 * 
	 * @return Game transaction if found
	 */
	public GameTransactionModel getGameTransaction(String transactionId) {
		return storage.get(transactionId);
	}
	
	/**
	 * Get all game transaction
	 * 
	 * @return Collection of Game transactions
	 */
	public Collection<GameTransactionModel> getAllTransactions() {
		return storage.values();
	}
}
