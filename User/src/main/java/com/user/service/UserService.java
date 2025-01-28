package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.dto.AssessmentDto;
import com.user.dto.BankAccountDto;
import com.user.dto.CourseDto;
import com.user.dto.EnrollmentDto;
import com.user.dto.Paymentdto;
import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.util.ResourceNotFoundException;

import jakarta.validation.Valid;

public interface UserService {

	List<User> bylist();

	User save(UserDto user);

	public User fetch(int id) throws ResourceNotFoundException;

	List<User> list() throws ResourceNotFoundException;

	boolean remove(int id) throws ResourceNotFoundException;

	void updateEmail(String email, int id) throws ResourceNotFoundException;

	void updateName(String name, int id) throws ResourceNotFoundException;

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	String enroll(EnrollmentDto d);

	void updateEnrollStatus(int id);

	List<CourseDto> fetch(String Coursename);

	EnrollmentDto findById(int id);

	List<EnrollmentDto> listOfEnrollments();

	void delete(int accountId);

	BankAccountDto getBankAccount(int accountId);

	public String processPayment(Paymentdto paymentdto);

	List<EnrollmentDto> listByUserId(int userId);

	public List<AssessmentDto> findAssessmentByName(String courseName);

	public void updateAssessment(String name);

	public List<AssessmentDto> getAllAssessments();

	public double checkbalance(int accountId);

	public ResponseEntity<String> withdraw(int accountId, double amount);

	public ResponseEntity<String> deposit(int accountId, double amount);

}
