package com.pstomi.gametransaction.service;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pstomi.gametransaction.controller.GameTransactionController;
import com.pstomi.gametransaction.model.GameTransactionModel;

@Service
@RequestMapping(path = "/gametransaction", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameTransactionRestService {
	
    private static final Logger logger = LogManager.getLogger(GameTransactionRestService.class);
	
	private GameTransactionController controller;

	@GetMapping("/transaction/{transactionId}")
	@ResponseBody
	public GameTransactionModel getTransaction(@PathVariable("transactionId") String transactionId) {
		logger.info("Received request to receive for the {} transaction", transactionId);
		return controller.getGameTransaction(transactionId);
	}
	
	@GetMapping("/all-transactions")
	@ResponseBody
	public Collection<GameTransactionModel> getAllTransactions() {
		logger.info("Received request to receive all transaction");
		return controller.getAllTransactions();
	}
	
	@PostMapping("/store-transaction")
	@ResponseBody
	public ResponseEntity<String> storeTransaction(GameTransactionModel transaction) {
		logger.info("Received request to store the {} transaction", transaction.getTransactionId());
		if(controller.addGameTransaction(transaction)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	public GameTransactionController getController() {
		return controller;
	}

	@Autowired
	public void setController(GameTransactionController controller) {
		this.controller = controller;
	}
}
