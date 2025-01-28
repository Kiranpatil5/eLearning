package com.ck.repo;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ck.entity.Assessment;
import jakarta.transaction.Transactional;
 
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
 
	@Modifying
	@Transactional
	@Query("UPDATE Assessment SET assessmentStatus='active' WHERE courseName=:courseName")
	void updateStatusByName(@Param("courseName") String courseName);
	@Query("FROM Assessment WHERE courseName=:courseName")
	List<Assessment> findByName(@Param("courseName")String courseName);
}

