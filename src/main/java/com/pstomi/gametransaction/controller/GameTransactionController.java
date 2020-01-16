package com.pstomi.gametransaction.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import com.pstomi.gametransaction.model.GameTransactionModel;

public class GameTransactionController {
	private final Map<String, GameTransactionModel> storage;
	
    private static GameTransactionController instance = null; 
    
    private GameTransactionController()  { 
    	storage = new HashMap<String, GameTransactionModel>();
    }
    
    public static GameTransactionController getInstance() 
    { 
        if (instance == null) 
        	instance = new GameTransactionController(); 
  
        return instance; 
    } 
	
	public boolean addGameTransaction(GameTransactionModel transaction) {
		storage.put(transaction.getTransactionId(), transaction);
		return storage.containsKey(transaction.getTransactionId());
	}
	
	public GameTransactionModel getGameTransaction(String transactionId) {
		return storage.get(transactionId);
	}
	
	public Collection<GameTransactionModel> getAllTransactions() {
		return storage.values();
	}
}
