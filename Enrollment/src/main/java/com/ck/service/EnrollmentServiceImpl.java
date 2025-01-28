package com.ck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.dto.EnrollmentDto;
import com.ck.entity.Enrollment;
import com.ck.repo.EnrollmentRepository;
@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
    EnrollmentRepository enrollmentRepository;
	
	@Override
	public String enrollCourse(EnrollmentDto e) {
		Enrollment enrollment=new Enrollment();
		enrollment.setUserId(e.getUserId());
		enrollment.setCourseId(e.getCourseId());
		enrollmentRepository.save(enrollment);
	    return "Enrollment has Done";
	}

	@Override
	public Enrollment fetch(int enrollmentId) {
		return enrollmentRepository.findById(enrollmentId).get();
	}

	@Override
	public List<Enrollment> list() {
		return enrollmentRepository.findAll();
	}

	@Override
	public String remove(int enrollmentId) {
		enrollmentRepository.deleteById(enrollmentId);
		return "Enrollment has Deleted";
	}

	@Override
	public String updateEnrollStatus(int id) {
		enrollmentRepository.updateStatus(id);
		return "Status Updated";
	}

}
