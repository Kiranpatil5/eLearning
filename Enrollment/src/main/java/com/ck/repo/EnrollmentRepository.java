package com.ck.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ck.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE Enrollment e SET e.paymentStatus = 'completed' WHERE e.id = :id")
	void updateStatus(@Param("id") int id);


}
