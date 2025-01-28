package com.user.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CourseDto {
	@NotNull(message = "Course ID should not be null")
	private int CId;
	@NotEmpty(message = "Couce Name should not be empty")
	private String cname;
	@NotEmpty(message = "Couce Description should not be empty")
	private String Description;
	@NotEmpty(message = "Couce Status should not be empty")
	private String Status;
	@Min(value = 0, message = "Course price should be greater than 0")
	private Double price;

	public int getCId() {
		return CId;
	}

	public void setCId(int cId) {
		CId = cId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CourseDto(@NotNull(message = "Course ID should not be Blank") int cId,
			@NotEmpty(message = "Couce Name should not be empty") String cname,
			@NotEmpty(message = "Couce Description should not be empty") String description,
			@NotEmpty(message = "Couce Status should not be empty") String status,
			@Min(value = 0, message = "Course price should be greater than 0") Double price) {
		super();
		CId = cId;
		this.cname = cname;
		Description = description;
		Status = status;
		this.price = price;
	}

	public CourseDto() {
		super();

	}
}
