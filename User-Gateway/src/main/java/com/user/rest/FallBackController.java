package com.user.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	@GetMapping("/userFallback")
	public ResponseEntity<String> userServiceFallback() {
		return new ResponseEntity<>("userservice is taking longer than expected\nPlease try after sometime",
				HttpStatus.GATEWAY_TIMEOUT);
	}

	@GetMapping("/assessmentFallback")
	public ResponseEntity<String> assessmentServiceFallback() {
		return new ResponseEntity<>("Assessment service is taking longer than expected. Please try after sometime.",
				HttpStatus.GATEWAY_TIMEOUT);
	}

	@GetMapping("/enrollmentFallback")
	public ResponseEntity<String> enrollmentServiceFallback() {
		return new ResponseEntity<>(
				"Enrollment service is taking longer than expected. Please try after sometime.",
				HttpStatus.GATEWAY_TIMEOUT);
	}
	@GetMapping("/courseFallback")
	public ResponseEntity<String> courseServiceFallback() {
		return new ResponseEntity<>(
				"Enrollment service is taking longer than expected. Please try after sometime.",
				HttpStatus.GATEWAY_TIMEOUT);
	}
	@GetMapping("/paymentFallback")
	public ResponseEntity<String> paymentServiceFallback() {
		return new ResponseEntity<>(
				"Enrollment service is taking longer than expected. Please try after sometime.",
				HttpStatus.GATEWAY_TIMEOUT);
	}

}