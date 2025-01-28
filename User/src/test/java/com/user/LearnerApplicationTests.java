package com.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.entity.User;
import com.user.repo.UserRepository;
import com.user.service.UserServiceImpl;

@SpringBootTest
class LearnerApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	 @Autowired
	    private UserRepository userRepository; 

	    @InjectMocks
	    private UserServiceImpl service; 

	    @Mock
	    private UserRepository repo; 

	    private User user;

	    @BeforeEach
	    public void setUp() {
	        user = new User();
	        user.setUserName("Kiran");
	        user.setUserId(101);
	        user.setEmailId("kp@gmail.com");
	        user.setDate(LocalDate.parse("2024-04-02"));
	        
	        userRepository.deleteAll(); 
	    }

	    @Test
	    void testSaveUser() {
	        User savedUser = userRepository.save(user);

	        assertNotNull(savedUser.getUserId(), "User ID should not be null");
	        assertEquals("Kiran", savedUser.getUserName(), "User name should match");
	        assertEquals("kp@gmail.com", savedUser.getEmailId(), "Email should match");
	        assertEquals(LocalDate.parse("2024-04-02"), savedUser.getDate(), "Date should match");
	    }

	    @Test
	    void testUpdateUserName() {
	        User savedUser = userRepository.save(user);

	        savedUser.setUserName("Raj");
	        userRepository.save(savedUser);

	        Optional<User> fetchedUser = userRepository.findById(savedUser.getUserId());

	        assertTrue(fetchedUser.isPresent(), "User should be present in the repository");
	        assertEquals("Raj", fetchedUser.get().getUserName(), "User name should be updated to 'Raj'");
	    }

//	    @Test
//	    void testFetchUserById() {
//	        userRepository.save(user);
//
//	        Optional<User> fetchedUser = userRepository.findById(101);
//
//	        
//	        assertEquals("Kiran", fetchedUser.get().getUserName(), "User name should match");
//	        assertEquals("kp@gmail.com", fetchedUser.get().getEmailId(), "Email should match");
//	    }

	    @Test
	    void testUserNotFoundById() {
	        Optional<User> fetchedUser = userRepository.findById(999);

	        assertFalse(fetchedUser.isPresent(), "User should not be found for the given ID");
	    }

}
