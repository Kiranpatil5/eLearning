package com.ck.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ck.dto.CourseDto;
import com.ck.entity.Course;
import com.ck.repo.CourseRepository;
import com.ck.service.CourseServiceImpl;
import com.ck.util.CourseNotFoundException;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {

	@Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    private CourseDto courseDto;
    private Course course;

    @BeforeEach
    public void setUp() {
        // Setup the test data
        courseDto = new CourseDto(1, "Java Basics", "Learn Java", "Active", 100.0);
        course = new Course(1, "Java Basics", "Learn Java", "Active", 100.0);
    }

    @Test
    public void testAddCourse() {
        
        when(courseRepository.save(any(Course.class))).thenReturn(course);

       
        courseService.addCourse(courseDto);

        
        verify(courseRepository, times(1)).save(any(Course.class));  
    }

    @Test
    public void testGetAllCourses() {
        
        List<Course> courses = Arrays.asList(course);
        when(courseRepository.findAll()).thenReturn(courses);

       
        List<Course> result = courseService.getAllCourses();

       
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(course, result.get(0));
    }

    @Test
    public void testFindByCourseName_CourseFound() throws CourseNotFoundException {
       
        List<Course> courses = Arrays.asList(course);
        when(courseRepository.findByCourseName("Java Basics")).thenReturn(courses);

      
        List<Course> result = courseService.findByCourseName("Java Basics");

       
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(course, result.get(0));
    }

    @Test
    public void testFindByCourseName_CourseNotFound() {
       
        when(courseRepository.findByCourseName("Non Existing Course")).thenReturn(Arrays.asList());

       
        assertThrows(CourseNotFoundException.class, () -> courseService.findByCourseName("Non Existing Course"));
    }

    @Test
    public void testGetPrice() {
       
        when(courseRepository.getPrice(1)).thenReturn(100.0);

       
        double price = courseService.getPrice(1);

       
        assertEquals(100.0, price);
    }

    @Test
    public void testFindByPrice() {
        
        List<Course> courses = Arrays.asList(course);
        when(courseRepository.findByPrice(100.0)).thenReturn(courses);

       
        List<Course> result = courseService.findByPrice(100.0);

       
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(course, result.get(0));
    }

    @Test
    public void testFindByStatus() throws CourseNotFoundException {
       
        List<Course> courses = Arrays.asList(course);
        when(courseRepository.findByStatus("Active")).thenReturn(courses);

       
        List<Course> result = courseService.findbystatus("Active");

       
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(course, result.get(0));
    }

    @Test
    public void testFindByStatus_CourseNotFound() {
       
        when(courseRepository.findByStatus("Inactive")).thenReturn(Arrays.asList());

        
        assertThrows(CourseNotFoundException.class, () -> courseService.findbystatus("Inactive"));
    }

    @Test
    public void testDelete() {
       
        courseService.delete(1);

        
        verify(courseRepository, times(1)).deleteById(1);
    }
}
    
    

