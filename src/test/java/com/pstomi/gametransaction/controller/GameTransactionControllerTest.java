package com.pstomi.gametransaction.controller;

import org.junit.Before;
import org.junit.Test;

import com.pstomi.gametransaction.model.GameTransactionModel;

import static org.junit.Assert.*;

public class GameTransactionControllerTest {
	
	private GameTransactionController controller;
	
	@Before
	public void setup() {
		controller = GameTransactionController.getInstance();
	}
	
	@Test
	public void testStoreTransaction() {
		boolean transactionStored = controller.addGameTransaction(new GameTransactionModel("user1", "product1", 100));
		assertTrue(transactionStored);
		transactionStored = controller.addGameTransaction(new GameTransactionModel("user1", "product1", 100));
		assertTrue(transactionStored);
		transactionStored = controller.addGameTransaction(new GameTransactionModel("user2", "product1", 100));
		assertTrue(transactionStored);
		assertEquals(3, controller.getAllTransactions().size());
	}

}
