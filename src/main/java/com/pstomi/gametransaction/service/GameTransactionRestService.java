package com.pstomi.gametransaction.service;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pstomi.gametransaction.controller.GameTransactionController;
import com.pstomi.gametransaction.model.GameTransactionModel;

@Controller
@RequestMapping(path = "/gametransaction", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameTransactionRestService {
	
    private static final Logger logger = LogManager.getLogger(GameTransactionRestService.class);
	
	GameTransactionController controller = GameTransactionController.getInstance();

	@GetMapping("/all-transactions")
	@ResponseBody
	public Collection<GameTransactionModel> getAllTransactions() {
		return controller.getAllTransactions();
	}
	
	@PostMapping("/store-transaction")
	@ResponseBody
	public ResponseEntity<String> storeTransaction(GameTransactionModel transaction) {
		controller.addGameTransaction(transaction);
		return ResponseEntity.ok().build();
		
	}

}
