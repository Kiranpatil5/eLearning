package com.user.rest;

import java.util.ArrayList;
import java.util.List;

//import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.BankAccountDto;
import com.user.dto.CourseDto;
import com.user.dto.EnrollmentDto;
import com.user.dto.Paymentdto;
import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.service.UserService;
//import com.user.util.ResourceNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/listBy")
	public ResponseEntity<List<User>> listby() {
		return new ResponseEntity<>(service.bylist(), HttpStatus.OK);
	}

	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<?> add(@RequestBody UserDto learner) {

		return new ResponseEntity<>(service.save(learner), HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<User>> list() {
		return new ResponseEntity<>(service.list(), HttpStatus.OK);
	}

	@GetMapping("/get/{userId}")
	public ResponseEntity<?> fetch(@PathVariable int userId) {
		return new ResponseEntity(service.fetch(userId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{code}")
	public ResponseEntity<?> remove(@PathVariable int code) {
		if (service.remove(code))
			return new ResponseEntity<>("User Deleted", HttpStatus.OK);
		return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);

	}

	@PutMapping(value = "/updateName/{id}/{name}")
	public ResponseEntity<String> setNameById(@Valid @PathVariable int id, @PathVariable String name) {

		service.updateName(name, id);
		return new ResponseEntity<>("User name updated successfully", HttpStatus.OK);

	}

	@PutMapping(value = "/updateEmail/{id}/{email}")
	public ResponseEntity<String> setEmailById(@Valid @PathVariable int id, @PathVariable String email) {
		service.updateName(email, id);
		return new ResponseEntity<>("User Email updated successfully", HttpStatus.OK);

	}

	@PostMapping(value = "/enroll", consumes = "application/json")
	public String enroll(@RequestBody EnrollmentDto d) {

		return service.enroll(d);
	}
}
