package com.ck.rest;

import com.ck.dto.BankAccountDto;
import com.ck.entity.BankAccount;
import com.ck.exception.AccountNotFoundException;
import com.ck.service.BankAccountservice;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment/Account")
public class BankController {

	@Autowired
	private BankAccountservice bankAccountService;

	@GetMapping(value = "/get/{accountNo}", produces = "application/json")
	public ResponseEntity<BankAccount> getBankAccount(@PathVariable int accountNo) throws AccountNotFoundException {
		BankAccount bankAccount = bankAccountService.getBankAccountById(accountNo);
		return ResponseEntity.ok(bankAccount);
	}

	@PostMapping(value = "/create", consumes = "application/json")
	public ResponseEntity<Integer> createBankAccount(@RequestBody BankAccountDto bankAccountdto) {
		int createdAccount = bankAccountService.createBankAccount(bankAccountdto);
		return ResponseEntity.ok(createdAccount);
	}

	@DeleteMapping("/delete/{accountNo}")
	public void delete(@PathVariable int accountNo) {
		bankAccountService.delete(accountNo);
	}
}
