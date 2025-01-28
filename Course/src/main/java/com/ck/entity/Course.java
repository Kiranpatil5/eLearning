package com.ck.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "course")
public class Course {
   
	@Id
	@Column(name = "course_id")
	private int courseId;
	@Column(name = "course_name")
	private String courseName;
	private String description;
	private String status;

	private double price;
	
	public Course() {
		
	}

	public Course(int courseId, String courseName, String description, String status, double price) {
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
