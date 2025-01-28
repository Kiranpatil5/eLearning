package com.ck.service;

import java.util.List;

import com.ck.dto.CourseDto;
import com.ck.entity.Course;
import com.ck.util.CourseNotFoundException;



public interface CourseService {
   
	 void addCourse(CourseDto c);

	List<Course> getAllCourses();

	List<Course> findByCourseName(String courseName) throws CourseNotFoundException;

	double getPrice(int courseId);
	
	void updateCourse(int courseId, CourseDto courseDto) throws CourseNotFoundException;

	List<Course> findbystatus(String status) throws CourseNotFoundException;

	void delete(int courseId);

	List<Course> findByPrice(double price);
}
