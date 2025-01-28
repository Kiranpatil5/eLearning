package com.user.rest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.dto.AssessmentDto;

import jakarta.validation.Valid;

@FeignClient("ASSESSMENT")
public interface AssessmentClient {

	@GetMapping(value = "/fetchByName/{courseName}")
	public List<AssessmentDto> findAssessmentByName(@PathVariable String courseName);

	@PutMapping(value = "/update/{assessmentName}")
	public void updateAssessment(@Valid @PathVariable String assessmentName);

	@GetMapping(value = "/fetchAll")
	public List<AssessmentDto> getAllAssessments();
}