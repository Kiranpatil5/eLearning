package com.ck.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    

	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<String> handleContentNotFound(CourseNotFoundException c) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(c.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String>handleGeneralException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured");
	}
}
