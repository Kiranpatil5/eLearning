package com.user.rest;

import java.util.List;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.dto.EnrollmentDto;

@FeignClient("ENROLLMENT")
public interface EnrollmentServiceClient {

	@PostMapping(value = "/enrollCourse", consumes = "application/json")
	String enroll(@RequestBody EnrollmentDto e);

	@PutMapping(value = "/updatePaymentStatus/{id}")
	public void updateStatusById(@PathVariable int id);

	@GetMapping(value = "/list", produces = "application/json")
	public List<EnrollmentDto> list();

	@GetMapping(value = "/listByUserId/{userId}", produces = "application/json")
	public List<EnrollmentDto> listByUserId(@PathVariable int userId);

	@GetMapping(value = "/fetch/{id}", produces = "application/json")
	public EnrollmentDto findById(@PathVariable int id);

}
