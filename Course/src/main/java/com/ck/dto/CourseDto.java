package com.ck.dto;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;


public class CourseDto {

	
	private int courseId;
	@NotEmpty(message = "Course Name should not be empty")
	private String courseName;
	@NotEmpty(message = "Course Description should not be empty")
	private String description;
	@NotEmpty(message = "Course Status should not be empty")
	private String status;
	@Min(value = 1, message = "Course price should be greater than 0")
	private double price;
	
	public CourseDto() {
		
	}
	

	public CourseDto(int courseId, String courseName, String description, String status, double price) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.status = status;
		this.price = price;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
