package com.profile.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

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
	
	@InjectMocks
	private UserController userController;

	@Before
	void initTest() {
		userController = Mockito.mock(UserController.class);
	}

	@Mock
	private UserRepository userRepository;

	@Test // testcase to check size of  list of users
	void GetuserTest() throws InvalidException {

		Mockito.when(userRepository.findAll())
				.thenReturn(Stream
						.of(new User(1, "aditi", "xyz", "user", "956324888", 0, "aditi@gmail.com"),
								new User(2, "ghjoi", "abc", "9573685246", "user", 23, "raj@gmail.com"))
						.collect(Collectors.toList()));
		assertEquals(2, userController.getalluser().size());

		//Mockito.when(userRepository.findAll().equals(null)).thenThrow(InvalidException.class);
		//assertEquals(null, userRepository.findAll());
	}

	@Test //testcase to check null list or empty list
	void Getusernull() {

		Mockito.when(userRepository.findAll().equals(null)).thenReturn(null);
		assertEquals(null, userController.getalluser());
	

	}

	@Test // test case for get all users
	void getUserTest1() {
		List<User> List1 = new ArrayList<>();

		List1.add(new User(1, "aditi", "xyz", "user", "956324888", 0, "aditi@gmail.com"));
		List1.add(new User(1, "aditi", "xyz", "user", "956324888", 0, "aditi@gmail.com"));
		List1.add(new User(1, "aditi", "xyz", "user", "956324888", 0, "aditi@gmail.com"));

		when(userRepository.findAll()).thenReturn(List1);

		assertEquals(List1, userController.getalluser());
	}

	@Test //testcase to check getalluser fuction test
	void getuserTest2() {
		List<User> List1 = new ArrayList<>();

		when(userRepository.findAll()).thenReturn(List1);

		assertEquals(List1, userController.getalluser());
	}

	@Test //testcase to check null parameter from list
	void GetuserTest2() throws InvalidException {

		List<User> list = userController.getalluser();

		for (User u : list) {

			if (u.getEmail().equals(null)) {

				Mockito.when(u.getEmail().equals(null)).thenThrow(InvalidException.class);

				assertNull(u.getEmail());

			} else if (u.getAddress().equals(null)) {

				Mockito.when(u.getAddress().equals(null)).thenThrow(InvalidException.class);

				assertNull(u.getAddress());

			} else if (u.getMobile().equals(null)) {

				Mockito.when(u.getMobile().equals(null)).thenThrow(InvalidException.class);

				assertNull(u.getAddress());

			} else if (u.getName().equals(null)) {

				Mockito.when(u.getName().equals(null)).thenThrow(InvalidException.class);

				assertNull(u.getName());

			} else if (u.getRole().equals(null)) {

				Mockito.when(u.getRole().equals(null)).thenThrow(InvalidException.class);

				assertNull(u.getRole());

			} else if (u.getAge() == 0) {

				Mockito.when(u.getAge() == 0).thenThrow(InvalidException.class);

				// assertNull(u.getAge());
				// assertEquals(0, 0);
			} else if (u.getUserId() == 0) {

				Mockito.when(u.getUserId() == 0).thenThrow(InvalidException.class);

				// assertNull(u.getUserId());
				// assertEquals(0, 0);
			}

		}

	}



	@Test // testcase for add new user 
	void AddUserTest1(){
		
		User user = new User(1, "aditi", "xyz", "user", "856322222", 22, "aditi@gmail.com");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userController.adduser(user));

	}

	@Test // test case for updating user information
	void updateuserTest1() {
		User user = new User(1, "aditi", "xyz", "admin", "9423020355", 0, "aditi@gmail.com");
		when(userRepository.getById((long) 1)).thenReturn(user);

		int age = 10;
		String name = "jerry";
		String address = "karma nagar";
		String role = "user";
		String mobile = "9536482144";
		String email = "jerry@gmail.com";

		User user1 = new User(1, name, address, role, mobile, age, email);
		when(userController.updateuser((long) 1, user1)).thenReturn(user);

		assertThat(user.getAge()).isEqualTo(age);
		assertThat(user.getName()).isEqualTo(name);
		assertThat(user.getAddress()).isEqualTo(address);
		assertThat(user.getEmail()).isEqualTo(email);
		assertThat(user.getRole()).isEqualTo(role);
		assertThat(user.getMobile()).isEqualTo(mobile);
	}

	@Test // testcase to delete user according to given userId
	void deleteUserTest() {
		Long user = (long) 1;
		userController.deleteuser(user);
		verify(userRepository, times(1)).deleteById(user);
	}

	@Test // test case for delete 
	void deleteuserTest1() {
		User user = new User(1, "aditi", "xyz", "9423020355", "user", 45, "aditi@gmail.com");

		when(userRepository.getById((long) 1)).thenReturn(user);

		userController.deleteuser((long) 1);

		verify(userRepository, times(1)).deleteById((long) 1);

	}
}