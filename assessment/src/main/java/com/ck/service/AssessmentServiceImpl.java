package com.ck.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ck.dto.AssessmentDto;
import com.ck.entity.Assessment;
import com.ck.repo.AssessmentRepository;
import com.ck.util.AssessmentNotFoundException;
 
@Service
public class AssessmentServiceImpl implements AssessmentService {
 
	@Autowired
	private AssessmentRepository repo;
 
	@Override
	public void createAssessment(AssessmentDto assessment) {
		Assessment a = new Assessment();
		a.setAssessmentId(assessment.getAssessmentId());
		a.setAssessmentName(assessment.getAssessmentName());
		a.setCourseName(assessment.getCourseName());
		a.setAssessmentDuration(assessment.getAssessmentDuration());
		a.setAssessmentMarks(assessment.getAssessmentMarks());
		a.setAssessmentStatus(assessment.getAssessmentStatus());
		repo.save(a);
	}
 
	@Override
	public void updateStatus(String courseName) throws AssessmentNotFoundException {
		repo.updateStatusByName(courseName);
	}
 
	@Override
	public Assessment getAssessmentById(int assessmentId) throws AssessmentNotFoundException {
		return repo.findById(assessmentId).orElseThrow(() -> new AssessmentNotFoundException("Assessment Not Found"));
	}
 
	@Override
	public List<Assessment> getAllAssessment() {
		return repo.findAll();
	}
 
	@Override
	public void deleteAssessmentById(int assessmentId) throws AssessmentNotFoundException {
		if (repo.findById(assessmentId).isPresent()) {
			repo.deleteById(assessmentId);
		} else {
			throw new AssessmentNotFoundException("Assessment Not Found");
		}
	}
 
	@Override
	public List<Assessment> findAssessmentByName(String courseName) {
		return repo.findByName(courseName);
	}
 
}