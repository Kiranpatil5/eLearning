package com.ck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.dto.Paymentdto;
import com.ck.entity.BankAccount;
import com.ck.entity.Payment;
import com.ck.exception.AccountNotFoundException;
import com.ck.exception.InsufficientFundsException;
import com.ck.repo.BankRepository;
import com.ck.repo.PaymentRepository;

@Service
public class Paymentserviceimpl implements Paymentservice {
	@Autowired
	PaymentRepository paymentrepository;
	@Autowired
	private BankRepository bankRepository;

	@Override
	public String processPayment(Paymentdto paymentdto) throws  InsufficientFundsException, AccountNotFoundException {

		String withdrawalResult = withdraw(paymentdto.getAccountNo(), paymentdto.getAmount());

		Payment payment = new Payment();
		payment.setAccountNo(paymentdto.getAccountNo());
		payment.setAmount(paymentdto.getAmount());

		if (withdrawalResult.equals("Insufficient funds")) {
			throw new InsufficientFundsException("Insufficient funds in the account.");
		} 
		payment.setPaymentStatus("completed");
		paymentrepository.save(payment);
		return "true";
	}

	@Override
	public double checkbalance(int accountNo) throws AccountNotFoundException {
		BankAccount bankaccount = bankRepository.findById(accountNo)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with AccountNo: " + accountNo));;
		
		return bankaccount.getBalance();
	}

	@Override
	public String withdraw(int accountNo, double amount) throws  InsufficientFundsException, AccountNotFoundException {
		BankAccount bankaccount = bankRepository.findById(accountNo)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with AccountNo: " + accountNo));;
		
		if (bankaccount.getBalance() < amount) {
			throw new InsufficientFundsException("Insufficient funds");
		}
		double newBalance = bankaccount.getBalance() - amount;
		bankaccount.setBalance(newBalance);
		bankRepository.save(bankaccount);

		return "Withdrawal successful. New balance: " + newBalance;
	}

	@Override
	public String deposit(int accountNo, double depositamount) throws AccountNotFoundException {
		BankAccount bankAccount = bankRepository.findById(accountNo)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with AccountNo: " + accountNo));;

		double newBalance = bankAccount.getBalance() + depositamount;
		bankAccount.setBalance(newBalance);
		bankRepository.save(bankAccount);

		return "Deposit successful. New balance: " + newBalance;
	}
}
