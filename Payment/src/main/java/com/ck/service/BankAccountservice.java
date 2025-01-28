package com.ck.service;

import com.ck.dto.BankAccountDto;
import com.ck.entity.BankAccount;
import com.ck.exception.AccountNotFoundException;

public interface BankAccountservice {

	BankAccount getBankAccountById(int accountNo) throws AccountNotFoundException;

	int createBankAccount(BankAccountDto bankAccountdto);

	void delete(int accountNo);
	

}
