package com.user.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.dto.BankAccountDto;
import com.user.dto.Paymentdto;

@FeignClient("PAYMENT")
public interface PaymentServiceClient {

	// @@@@@@@@@@@@@@@@@@ BANK ACCOUNT

	@PostMapping("/Account/create")
	public int createBankAccount(@RequestBody BankAccountDto accountdto);

	@DeleteMapping("/Account/delete/{accountId}")
	public void delete(int accountId);

	@GetMapping(value = "/Account/get/{accountId}", produces = "application/json")
	public BankAccountDto getBankAccount(@PathVariable int accountId);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@ PAYMENT

	@PostMapping(value = "/payment/pay", consumes = "application/json")
	public String processPayment(@RequestBody Paymentdto paymentdto);

	@GetMapping(value = "/checkbalance/{accountNo}", produces = "application/json")
	public double checkbalance(@PathVariable int accountNo);

	@PutMapping("/withdraw/{accountNo}/{amount}")
	public ResponseEntity<String> withdraw(@PathVariable int accountNo, @PathVariable double amount);

	@PutMapping("/deposit/{accountNo}/{amount}")
	public ResponseEntity<String> deposit(@PathVariable int accountNo, @PathVariable double amount);

}
