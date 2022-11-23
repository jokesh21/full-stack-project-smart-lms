package com.spark.lms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;




import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spark.lms.model.User;
import com.spark.lms.repository.UserRepository;
import com.spark.lms.service.UserService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SparkLmsApplicationTests {
	@Autowired
	private UserService service ;
	
	@MockBean 
	private UserRepository repository;
	
						//	JUNIT TEST CASE FOR USER
	
	@Test 
	
public void shouldCreateUser() {
		service.addNeww("Virat", "ViratKohli", "123Pass","Student");
		Assertions.assertEquals(0, service.getAllUsers().size());
		
	}
	
	@Test
	
	public void saveUserTest() {
		User user = new User("Raghu","Raghu Ram","Password123","admin" );
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,service.addNew(user));
	}
	
	@Test
	 
	public void deleteUserTest() {
		User user = new User ("Raghu","Raghu Ram","Password123","admin");
		service.delete(user);
		verify(repository,times(1)).delete(user);
	}
	


	
	

	
	
	



	

}
