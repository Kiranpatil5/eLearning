package com.ck.entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class Assessment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int assessmentId;
 
	private String assessmentName;
 
	private String courseName;
 
	private int assessmentDuration;
 
	private String assessmentStatus; 
	private int assessmentMarks;
	public Assessment() {
	}
 
	public Assessment(int assessmentId, String assessmentName, String courseName, int assessmentDuration,
			String assessmentStatus, int assessmentMarks) {
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

