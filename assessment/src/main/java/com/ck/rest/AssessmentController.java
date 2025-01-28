package com.ck.rest;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ck.dto.AssessmentDto;
import com.ck.entity.Assessment;
import com.ck.service.AssessmentService;
import com.ck.util.AssessmentNotFoundException;
 
import jakarta.validation.Valid;
 
@RestController
@RequestMapping(value = "/assessment")
public class AssessmentController {
	@Autowired
	private AssessmentService assessmentService;
 
	@PostMapping(value = "/save")
	public void save(@Valid @RequestBody AssessmentDto assessment) {
		assessmentService.createAssessment(assessment);
	}
 
	@PutMapping(value = "/update/{courseName}")
	public ResponseEntity<String> updateStatus(@Valid @PathVariable String courseName)
			throws AssessmentNotFoundException {
		assessmentService.updateStatus(courseName);
		return ResponseEntity.ok("Enrolled into "+courseName+" Assessment");
	}
 
	@GetMapping(value = "/fetch/{assessmentId}")
	public Assessment getAssessmentById(@PathVariable int assessmentId) throws AssessmentNotFoundException {
		return assessmentService.getAssessmentById(assessmentId);
	}
 
	@GetMapping(value = "/fetchAll")
	public List<Assessment> getAllAssessments() {
		return assessmentService.getAllAssessment();
	}
 
	@DeleteMapping(value = "/remove/{assessmentId}")
	public void deleteAssessmentById(@PathVariable int assessmentId) throws AssessmentNotFoundException {
		assessmentService.deleteAssessmentById(assessmentId);
	}
	@GetMapping(value = "/fetchByName/{courseName}")
	public List<Assessment> findAssessmentByName(@PathVariable String courseName) {
		return assessmentService.findAssessmentByName(courseName);
	}
 
}

