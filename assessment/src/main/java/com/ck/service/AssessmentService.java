package com.ck.service;
 
import java.util.List;
import com.ck.dto.AssessmentDto;
import com.ck.entity.Assessment;
import com.ck.util.AssessmentNotFoundException;
 
public interface AssessmentService {
	void createAssessment(AssessmentDto assessment);
	void updateStatus(String courseName) throws AssessmentNotFoundException;
	Assessment getAssessmentById(int assessmentId) throws AssessmentNotFoundException;
	List<Assessment> getAllAssessment();
	void deleteAssessmentById(int assessmentId) throws AssessmentNotFoundException;
	List<Assessment> findAssessmentByName(String courseName);
}