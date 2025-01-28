package com.user.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.user.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select * from User LIMIT 5", nativeQuery = true)
	ArrayList findBylimit();

	@Query("FROM User  WHERE emailId Like '%@gmail.com'")
	List<User> findUserByEmailId();

	List<User> findUserByDate(LocalDate date);

	@Modifying
	@Transactional
	@Query("UPDATE User SET emailId =:email WHERE userId = :id")
	int updateEmail(String email, int id);

	@Modifying
	@Transactional
	@Query("UPDATE User SET userName=:name WHERE userId=:id")
	int updateName(String name, int id);

}
