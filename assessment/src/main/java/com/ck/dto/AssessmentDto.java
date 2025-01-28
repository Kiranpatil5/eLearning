package com.ck.dto;
 
import jakarta.validation.constraints.NotBlank;
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
 
	private String assessmentStatus="inactive";
 
	@PositiveOrZero(message = "Marks must be greater than zero")
	private int assessmentMarks;
 
	public AssessmentDto() {
 
	}
 
	public AssessmentDto(int assessmentId,
			@NotBlank(message = "Assessment name cannot be blank") @Size(max = 100, message = "Assessment name cannot exceed 100 characters") String assessmentName,
			@NotBlank(message = "Course name cannot be blank") @Size(max = 100, message = "Course name cannot exceed 100 characters") String courseName,
			@Positive(message = "Duration must be a positive number") int assessmentDuration, String assessmentStatus,
			@PositiveOrZero(message = "Marks must be greater than zero") int assessmentMarks) {
		super();
		this.assessmentId = assessmentId;
		this.assessmentName = assessmentName;
		this.courseName = courseName;
		this.assessmentDuration = assessmentDuration;
		this.assessmentStatus = assessmentStatus;
		this.assessmentMarks = assessmentMarks;
	}
 
	public int getAssessmentId() {
		return assessmentId;
	}
 
	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
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
 
	public int getAssessmentDuration() {
		return assessmentDuration;
	}
 
	public void setAssessmentDuration(int assessmentDuration) {
		this.assessmentDuration = assessmentDuration;
	}
 
	public String getAssessmentStatus() {
		return assessmentStatus;
	}
 
	public void setAssessmentStatus(String assessmentStatus) {
		this.assessmentStatus = assessmentStatus;
	}
 
	public int getAssessmentMarks() {
		return assessmentMarks;
	}
 
	public void setAssessmentMarks(int assessmentMarks) {
		this.assessmentMarks = assessmentMarks;
	}
 
	
}