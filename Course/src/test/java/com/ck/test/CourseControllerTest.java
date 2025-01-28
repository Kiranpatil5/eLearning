package com.ck.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import com.ck.dto.CourseDto;
import com.ck.entity.Course;
import com.ck.rest.CourseController;
import com.ck.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CourseController.class)
class CourseControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CourseService courseservice;

	private CourseDto mockDto;
	private Course mockEntity;

	
	
	@BeforeEach
	public void setup() {
		mockDto = new CourseDto(1, "Java Programming", "Lean Java", "active", 199.99);
		mockEntity = new Course(1, "Java Programming", "Lean Java", "active", 199.99);

	}
	
	
	

	@Test()
	void getAllCoursestest() throws Exception {
		doNothing().when(courseservice).addCourse(any(CourseDto.class));

		mockMvc.perform(post("/courses/save").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(mockDto))).andExpect(status().isOk());

		verify(courseservice, times(1)).addCourse(any(CourseDto.class));
	}
	
	

	@Test
	void testGetAllCourses() throws Exception {
		List<Course> courses = Arrays.asList(mockEntity);
        when(courseservice.getAllCourses()).thenReturn(courses);
        
        mockMvc.perform(get("/courses/listall"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].courseId").value(1))
               .andExpect(jsonPath("$[0].courseName").value("Java Programming"))
               .andExpect(jsonPath("$[0].description").value("Lean Java"))
               .andExpect(jsonPath("$[0].status").value("active"))
               .andExpect(jsonPath("$[0].price").value(199.99));
               
               verify(courseservice, times(1)).getAllCourses();
          
	   }
	
	

	@Test
	void testFindByCourseName() throws Exception {
		List<Course> courses = Arrays.asList(mockEntity);
        when(courseservice.findByCourseName("Java Programming")).thenReturn(courses);
        
        
        mockMvc.perform(get("/courses/name/{courseName}","Java Programming"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].courseId").value(1))
        .andExpect(jsonPath("$[0].courseName").value("Java Programming"))
        .andExpect(jsonPath("$[0].description").value("Lean Java"))
        .andExpect(jsonPath("$[0].status").value("active"))
        .andExpect(jsonPath("$[0].price").value(199.99));
        
        verify(courseservice, times(1)).findByCourseName("Java Programming");
        
	}
	
	
	
	@Test
	void testGetPrice() throws Exception {
	    when(courseservice.getPrice(1)).thenReturn(199.99);

	    mockMvc.perform(get("/courses/price/{courseId}", 1))
	           .andExpect(status().isOk())
	           .andExpect(jsonPath("$").value(199.99));

	    verify(courseservice, times(1)).getPrice(1);
	}
	
	
	
	@Test
	void testFindByStatus() throws Exception {
	    List<Course> courses = Arrays.asList(mockEntity);
	    when(courseservice.findbystatus("active")).thenReturn(courses);

	    mockMvc.perform(get("/courses/status/{status}", "active"))
	           .andExpect(status().isOk())
	           .andExpect(jsonPath("$[0].courseId").value(1))
	           .andExpect(jsonPath("$[0].courseName").value("Java Programming"))
	           .andExpect(jsonPath("$[0].description").value("Lean Java"))
	           .andExpect(jsonPath("$[0].status").value("active"))
	           .andExpect(jsonPath("$[0].price").value(199.99));

	    verify(courseservice, times(1)).findbystatus("active");
	}
	
	

	@Test
	void testDeleteCourseById() throws Exception {
		doNothing().when(courseservice).delete(1);

		mockMvc.perform(delete("/courses/{courseId}", 1)).andExpect(status().isOk());

		verify(courseservice, times(1)).delete(1);
	}

}
