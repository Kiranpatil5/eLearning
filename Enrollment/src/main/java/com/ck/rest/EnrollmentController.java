package com.ck.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ck.dto.EnrollmentDto;
import com.ck.entity.Enrollment;
import com.ck.service.EnrollmentService;

@RestController
@RequestMapping("/Enrollment")
public class EnrollmentController {
 
	@Autowired
	private EnrollmentService service;
	
	@PostMapping(value="/enrollCourse",consumes="application/json")
	public String enrollCourse(@RequestBody EnrollmentDto e) {
		return service.enrollCourse(e);
	}
	@GetMapping(value="/fetch/{id}",produces = "application/json")
	public Enrollment findById(@PathVariable int id) {
		return service.fetch(id);
	}
	@GetMapping(value="/list",produces="application/json")
	public List<Enrollment> list(){
		return service.list();
	}
	@DeleteMapping(value="/remove/{id}")
	public String remove(@PathVariable int id) {
		return service.remove(id);
	}
	@PutMapping(value="/updatePaymentStatus/{id}")
	public void updateStatusById(@PathVariable int id) {
		service.updateEnrollStatus(id);
	}
}
