package com.user.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@Min(value = 1, message = "Learner ID must be greater than or equal to 1")
	@Max(value = 10000, message = "Learner ID must be less than or equal to 10000")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;

	@Length(min = 5, max = 20)
	private String userName;

	@NotNull(message = "Date should not be blank")
	@Future(message = "Event start date must be in the future.")
	private LocalDate date = LocalDate.now().plusDays(1);

	@NotBlank(message = "email should not be blank")
	@Email
	private String emailId;
	private int accountNo;

	public UserDto() {
		super();
	}

	public UserDto(
			@Min(value = 1, message = "Learner ID must be greater than or equal to 1") @Max(value = 10000, message = "Learner ID must be less than or equal to 10000") int userId,
			@NotBlank(message = "Name should not be blank") @Pattern(regexp = "^[A-Za-z]+$") @Length(min = 1, max = 20) String userName,
			@NotNull(message = "Date should not be blank") @Future(message = "Event start date must be in the future.") LocalDate date,
			@NotBlank(message = "email should not be blank") @Email String emailId, int accountNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.date = date;
		this.emailId = emailId;
		this.accountNo = accountNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

}
