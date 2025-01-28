package com.ck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.dto.CourseDto;
import com.ck.entity.Course;
import com.ck.repo.CourseRepository;
import com.ck.util.CourseNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {
    
	
	@Autowired
    private CourseRepository courserepository;
	
	@Override
	public void addCourse(CourseDto c) {
		Course course = new Course();
        course.setCourseId(c.getCourseId());
        course.setCourseName(c.getCourseName());
        course.setDescription(c.getDescription());
        course.setStatus(c.getStatus());
        course.setPrice(c.getPrice());

        
        courserepository.save(course);
		
	}

	@Override
	public List<Course> getAllCourses() {
		
		return courserepository.findAll();
	}

	@Override
	public List<Course> findByCourseName(String courseName) throws CourseNotFoundException {
		
		List<Course> courses = courserepository.findByCourseName(courseName);
        if (courses.isEmpty()) {
            throw new CourseNotFoundException("Course not found with name: " + courseName);
        }
        return courses;
	}

	@Override
	public double getPrice(int courseId) {
		
		return courserepository.getPrice(courseId);
	}
	
	public List<Course> findByPrice(double price) {
        return courserepository.findByPrice(price);
    }

	@Override
	public List<Course> findbystatus(String status) throws CourseNotFoundException {
		
		List<Course> courses = courserepository.findByStatus(status);
        if (courses.isEmpty()) {
            throw new CourseNotFoundException("No courses found with status: " + status);
        }
        return courses;
    }
	
	
	@Override
    public void updateCourse(int courseId, CourseDto courseDto) throws CourseNotFoundException {
        Course course = courserepository.findById(courseId)
            .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + courseId));

        course.setCourseName(courseDto.getCourseName());
        course.setDescription(courseDto.getDescription());
        course.setStatus(courseDto.getStatus());
        course.setPrice(courseDto.getPrice());

       
        courserepository.save(course);
    }
		
	

	@Override
	public void delete(int courseId) {
		courserepository.deleteById(courseId);	
	}

	
}
