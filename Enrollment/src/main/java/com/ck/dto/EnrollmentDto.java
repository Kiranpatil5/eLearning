package com.ck.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class EnrollmentDto {
 
	@NotNull(message = "id should not be null")
	private int id;
	@NotNull(message = "CourseId should not be null")
	private int courseId;
	@NotNull(message = "userId should not be null")
	private int userId;
	private LocalDate date;
	private String paymentStatus;
	public EnrollmentDto(@NotNull(message = "id should not be null") int enrollmentId,
			@NotNull(message = "CourseId should not be null") int courseId,
			@NotNull(message = "userId should not be null") int userId, LocalDate date, String payment) {
		super();
		this.id = enrollmentId;
		this.courseId = courseId;
		this.userId = userId;
		this.date = date;
		this.paymentStatus = payment;
	}
 
	public EnrollmentDto() {
	}
 
	public int getEnrollmentId() {
		return id;
	}
 
	public void setEnrollmentId(int enrollmentId) {
		this.id = enrollmentId;
	}
 
	public int getCourseId() {
		return courseId;
	}
 
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
 
	public int getUserId() {
		return userId;
	}
 
	public void setUserId(int userId) {
		this.userId = userId;
	}
 
	public LocalDate getDate() {
		return date;
	}
 
	public void setDate(LocalDate date) {
		this.date = date;
	}
 
	public String getPaymentStatus() {
		return paymentStatus;
	}
 
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
