package com.ck.rest;
 
import java.util.List;
 
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
 
import com.ck.entity.Assessment;
 
import jakarta.validation.Valid;
 
@FeignClient(name = "assessment", url = "http://10.236.124.104:9005")
public interface AssessmentClient {
 
	@GetMapping(value = "/fetchByName/{courseName}")
	public List<Assessment> findAssessmentByName(@PathVariable String courseName);
 
	@PutMapping(value = "/update/{courseName}")
	public void updateAssessment(@Valid @PathVariable String courseName);
 
	@GetMapping(value = "/fetchAll")
	public List<Assessment> getAllAssessments();
}
 