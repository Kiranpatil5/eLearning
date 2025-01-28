//package com.ck.feignclient;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.ck.entity.Course;
//
//@FeignClient(name = "Course", url = "http://10.236.124.228:9002")
//public interface CourseClient {
//   
//	@GetMapping("/name/{courseName}")
//	public List<Course> findByCourseName(@PathVariable String courseName);
//	
//	
//	@GetMapping("/price/list/{price}")
//	public List<Course> listByPrice(@PathVariable double price);
//}
