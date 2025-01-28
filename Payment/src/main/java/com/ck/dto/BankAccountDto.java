package com.ck.dto;

public class BankAccountDto {

	private int accountNo;
	private double balance;
	private String accountHolderName;

	public BankAccountDto(int accountNo, double balance, String accountHolderName) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.accountHolderName = accountHolderName;
	}

	public BankAccountDto() {
		super();
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

}
