package com.user.rest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.dto.CourseDto;

@FeignClient("COURSE")
public interface CourseServiceClient {

	@GetMapping("/name/{courseName}")
	public List<CourseDto> findByCourseName(@PathVariable String courseName);

	@GetMapping("/price/list/{price}")
	public List<CourseDto> listByPrice(@PathVariable double price);

	@GetMapping(value = "/getPrice/{courseId}", produces = "application/json")
	public double getPrice(@PathVariable int courseId);
}