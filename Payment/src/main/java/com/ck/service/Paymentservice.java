package com.ck.service;
import com.ck.dto.Paymentdto;
import com.ck.exception.AccountNotFoundException;
import com.ck.exception.InsufficientFundsException;
public interface Paymentservice {

	String processPayment(Paymentdto paymentDTO) throws InsufficientFundsException, AccountNotFoundException;

	double checkbalance(int accountNo) throws AccountNotFoundException;

	String withdraw(int accountNo, double amount) throws  InsufficientFundsException, AccountNotFoundException;

	String deposit(int accountNo, double depositamount) throws AccountNotFoundException ;

}
