package com.profile.api;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.profile.api.controller.UserController;
import com.profile.api.model.User;
import com.profile.api.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProfileServiceApplicationTests {

	
	/*
	 * @Test void contextLoads() { }
	 */

	  @Autowired
		private UserController userController;
	  
		@MockBean
		private UserRepository userRepository;
	
	
		@Test
		public void GetuserTest() {
			when(userRepository.findAll()).thenReturn(Stream
					.of(new User(1, "aditi", "xyz", "9423020355", "user",22,"aditi@gmail.com"), new User(2, "rutu", "abc", "9573685246", "user", 23, "raj@gmail.com")).collect(Collectors.toList()));
			assertEquals(2, userController.getAllUser().size());
		}
			

		@Test
		public void AddUserTest() {
			User user = new User(1, "aditi", "xyz", "9423020355", "user",22,"aditi@gmail.com");
			when(userRepository.save(user)).thenReturn(user);
			assertEquals(user, userController.adduser(user));
		
	
			}
		
		
		@Test
		public void deleteUserTest() {
			Long user = (long) 1;
			userController.deleteUser(user);
			verify(userRepository, times(1)).deleteById(user);
		}
}