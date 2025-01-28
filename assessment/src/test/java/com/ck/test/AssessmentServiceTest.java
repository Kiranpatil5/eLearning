package com.ck.test;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import com.ck.dto.AssessmentDto;
import com.ck.entity.Assessment;
import com.ck.repo.AssessmentRepository;
import com.ck.service.AssessmentServiceImpl;
import com.ck.util.AssessmentNotFoundException;
 
class AssessmentControllerTest {
 
	@InjectMocks
	private AssessmentServiceImpl service;
 
	@Mock
	private AssessmentRepository repo;
 
	private AssessmentDto mockDto;
 
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockDto = new AssessmentDto(1, "Sample Assessment", "Math", 120, "inactive", 100);
	}
 
	@Test
	void testCreateAssessment() {
		service.createAssessment(mockDto);
		verify(repo, times(1)).save(any(Assessment.class));
	}
 
	@Test
	void testUpdateStatus() throws AssessmentNotFoundException {
		String assessmentName = "Sample";
 
		service.updateStatus(assessmentName);
 
		verify(repo, times(1)).updateStatusByName(assessmentName);
	}
 
	@Test
	void testGetAssessmentByIdFound() throws AssessmentNotFoundException {
		int id = mockDto.getAssessmentId();
		Assessment mockAssessment = new Assessment();
		mockAssessment.setAssessmentId(id);
		when(repo.findById(id)).thenReturn(Optional.of(mockAssessment));
 
		Assessment result = service.getAssessmentById(id);
 
		assertNotNull(result);
		verify(repo, times(1)).findById(id);
	}
 
	@Test
	void testGetAllAssessment() {
		when(repo.findAll()).thenReturn(Arrays.asList(new Assessment(), new Assessment()));
 
		List<Assessment> result = service.getAllAssessment();
 
		assertNotNull(result);
		assertEquals(2, result.size());
		verify(repo, times(1)).findAll();
	}
 
	@Test
	void testDeleteAssessmentByIdFound() throws AssessmentNotFoundException {
		int id = 1;
		when(repo.findById(id)).thenReturn(Optional.of(new Assessment()));
 
		service.deleteAssessmentById(id);
 
		verify(repo, times(1)).deleteById(id);
	}
 
	@Test
	void testFindAssessmentByName() {
		String courseName = "Math";
		when(repo.findByName(courseName)).thenReturn(Arrays.asList(new Assessment(), new Assessment()));
 
		List<Assessment> result = service.findAssessmentByName(courseName);
 
		assertNotNull(result);
		assertEquals(2, result.size());
		verify(repo, times(1)).findByName(courseName);
	}
}