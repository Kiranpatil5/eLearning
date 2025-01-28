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

import com.ck.dto.CourseDto;
import com.ck.entity.Course;
import com.ck.service.CourseService;
import com.ck.util.CourseNotFoundException;

@RestController
@RequestMapping("/course")
public class CourseController {
    
	@Autowired
    private CourseService courseService;
	
	@PostMapping(value="/save", consumes="application/json")
    public ResponseEntity<String> addCourse(@RequestBody CourseDto courseDto) {
        courseService.addCourse(courseDto);
        return ResponseEntity.ok("Course added successfully.");
    }
	
	
	@GetMapping(value = "/list", produces = "application/json")
	public ResponseEntity<List<Course>> getAllCourses() {
	    List<Course> courses = courseService.getAllCourses();
	    if (courses.isEmpty()) {
	        return ResponseEntity.status(404).body(null);  
	    }
	    return ResponseEntity.ok(courses);  
	}
	
	@GetMapping("/name/{courseName}")
    public ResponseEntity<List<Course>> findByCourseName(@PathVariable String courseName) {
        try {
            List<Course> courses = courseService.findByCourseName(courseName);
            return ResponseEntity.ok(courses);
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
	
	@GetMapping("/price/{courseId}")
    public ResponseEntity<Double> getPrice(@PathVariable int courseId) {
        double price = courseService.getPrice(courseId);
        return ResponseEntity.ok(price);
    }
	
	@GetMapping("/price/list/{price}")
    public ResponseEntity<List<Course>> listByPrice(@PathVariable double price) {
        List<Course> courses = courseService.findByPrice(price);
        if (courses.isEmpty()) {
            return ResponseEntity.status(404).body(null); 
        }
        return ResponseEntity.ok(courses); 
    }
	
	@GetMapping("/status/{status}")
    public ResponseEntity<List<Course>> findByStatus(@PathVariable String status) {
        try {
            List<Course> courses = courseService.findbystatus(status);
            return ResponseEntity.ok(courses);
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(404).body(null); 
        }
    }
	
	@PutMapping("/{courseId}")
    public ResponseEntity<String> updateCourse(@PathVariable int courseId, @RequestBody CourseDto courseDto) {
        try {
            courseService.updateCourse(courseId, courseDto);
            return ResponseEntity.ok("Course updated successfully.");
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(404).body("Course not found.");
        }
    }
	
	
	@DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable int courseId) {
        courseService.delete(courseId);
        return ResponseEntity.ok("Course deleted successfully.");
    }
}
