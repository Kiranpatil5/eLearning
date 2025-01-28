package com.ck.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ck.entity.Course;



public interface CourseRepository extends JpaRepository<Course, Integer> {
    
	//@Query("FROM Course WHERE courseName=:courseName")
	@Query("FROM Course WHERE courseName LIKE %:courseName%")
	public List<Course> findByCourseName(String courseName);
	
	@Query("FROM Course WHERE status=:status")
	public List<Course> findByStatus(String status);
	
	@Query("SELECT price FROM Course WHERE courseId = :courseId")
    double getPrice(@Param("courseId") int courseId);
	
	
	
	@Query("FROM Course WHERE price = :price")
	public List<Course> findByPrice(double price);
}
