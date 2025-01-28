package com.ck.service;

import java.util.List;

import com.ck.dto.EnrollmentDto;
import com.ck.entity.Enrollment;

public interface EnrollmentService {
   
	String enrollCourse(EnrollmentDto e);
	
	Enrollment fetch(int enrollmentId);
	
	List<Enrollment> list();
	
	String remove(int enrollmentId);
	
	String updateEnrollStatus(int id);
}
