package com.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class AssessmentDto {

	private int assessmentId;

	@NotBlank(message = "Assessment name cannot be blank")
	@Size(max = 100, message = "Assessment name cannot exceed 100 characters")
	private String assessmentName;

	@NotBlank(message = "Course name cannot be blank")
	@Size(max = 100, message = "Course name cannot exceed 100 characters")
	private String courseName;

	@Positive(message = "Duration must be a positive number")
	private int assessmentDuration;

	private String assessmentStatus = "inactive";

	@PositiveOrZero(message = "Marks must be greater than zero")
	private int assessmentMarks;

	public AssessmentDto() {

	}

	public AssessmentDto(int id, String assessmentName, String courseName, int duration, String status, int marks) {
		super();
		this.assessmentId = id;
		this.assessmentName = assessmentName;
		this.courseName = courseName;
		this.assessmentDuration = duration;
		this.assessmentStatus = status;
		this.assessmentMarks = marks;
	}

	public int getId() {
		return assessmentId;
	}

	public void setId(int id) {
		this.assessmentId = id;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return assessmentDuration;
	}

	public void setDuration(int duration) {
		this.assessmentDuration = duration;
	}

	public String getStatus() {
		return assessmentStatus;
	}

	public void setStatus(String status) {
		this.assessmentStatus = status;
	}

	public int getMarks() {
		return assessmentMarks;
	}

	public void setMarks(int marks) {
		this.assessmentMarks = marks;
	}

}