package com.user.dto;

public class UserAccountDto {

	private UserDto learnerDto;

	private BankAccountDto accountDto;

	// Getters and setters
	public UserDto getLearnerDto() {
		return learnerDto;
	}

	public void setLearnerDto(UserDto learnerDto) {
		this.learnerDto = learnerDto;
	}

	public BankAccountDto getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(BankAccountDto accountDto) {
		this.accountDto = accountDto;
	}
}
