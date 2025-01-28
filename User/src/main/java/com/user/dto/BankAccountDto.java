package com.user.dto;

public class BankAccountDto {

	private int accountId;
	private double balance;
	private String accountHolderName;

	public BankAccountDto(int accountId, double balance, String accountHolderName) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.accountHolderName = accountHolderName;
	}

	public BankAccountDto() {

	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
