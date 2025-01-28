package com.ck.service;

import com.ck.dto.BankAccountDto;
import com.ck.entity.BankAccount;
import com.ck.exception.AccountNotFoundException;
import com.ck.repo.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountserviceimpl implements BankAccountservice {

	@Autowired
	private BankRepository repo;

	public BankAccount getBankAccountById(int accountNo) throws AccountNotFoundException {
		return repo.findById(accountNo)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with AccountNo: " + accountNo));

	}

	public int createBankAccount(BankAccountDto bankAccountdto) {
		bankAccountdto.setBalance(1000.0);
		BankAccount bankaccount = new BankAccount();
		bankaccount.setAccountNo(bankAccountdto.getAccountNo());
		bankaccount.setBalance(bankAccountdto.getBalance());
		bankaccount.setAccountHolderName(bankAccountdto.getAccountHolderName());
		repo.save(bankaccount);
		return bankaccount.getAccountNo();
	}

	@Override
	public void delete(int accountNo) {
		repo.deleteById(accountNo);
	}

}
