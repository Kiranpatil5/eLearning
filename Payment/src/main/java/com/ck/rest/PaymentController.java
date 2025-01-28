package com.ck.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ck.dto.Paymentdto;
import com.ck.exception.AccountNotFoundException;
import com.ck.exception.InsufficientFundsException;
import com.ck.service.Paymentservice;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private Paymentservice paymentService;

	@PostMapping(value = "/pay", consumes = "application/json")
	public ResponseEntity<String> processPayment(@RequestBody Paymentdto paymentdto)
			throws InsufficientFundsException, AccountNotFoundException {
		String result = paymentService.processPayment(paymentdto);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/checkbalance/{accountNo}", produces = "application/json")
	public double checkbalance(@PathVariable int accountNo) throws AccountNotFoundException{
		return paymentService.checkbalance(accountNo);
	}

	@PutMapping("/withdraw/{accountNo}/{amount}")
	public ResponseEntity<String> withdraw(@PathVariable int accountNo, @PathVariable double amount)
			throws  InsufficientFundsException, AccountNotFoundException {
		String result = paymentService.withdraw(accountNo, amount);
		return ResponseEntity.ok(result);
	}

	@PutMapping("/deposit/{accountNo}/{amount}")
	public ResponseEntity<String> deposit(@PathVariable int accountNo, @PathVariable double amount) throws AccountNotFoundException
			 {
		String result = paymentService.deposit(accountNo, amount);
		return ResponseEntity.ok(result);
	}
	

}
