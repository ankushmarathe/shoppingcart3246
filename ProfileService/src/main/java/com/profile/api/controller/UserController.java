package com.profile.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.profile.api.model.User;
import com.profile.api.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// post method to add new user
	@PostMapping("/user")
	public User adduser(@RequestBody User user) {

		return userRepository.save(user);
	}

	// get method to get all users list
	@GetMapping("/R")
	public List<User> getalluser() {

		return userRepository.findAll();
	}

	// delete method to delete user using user ID
	@DeleteMapping("/user/{uid}")
	public void deleteuser(@PathVariable("uid") Long uid) {
		userRepository.deleteById(uid);
	}

	// pur method to update user according to user ID
	@PutMapping("/user/update/{uid}")
	public User updateuser(@PathVariable("uid") Long uid, @RequestBody User newuser) {

		User userDB = userRepository.getById(uid);

		if (newuser.getName() != null)
			userDB.setName(newuser.getName());

		if (newuser.getAddress() != null)
			userDB.setAddress(newuser.getAddress());
		if (newuser.getRole() != null)
			userDB.setRole(newuser.getRole());

		if (newuser.getMobile() != null)
			userDB.setMobile(newuser.getMobile());

		if (newuser.getAge() != 0)
			userDB.setAge(newuser.getAge());

		if (newuser.getEmail() != null)
			userDB.setEmail(newuser.getEmail());

		return userRepository.save(userDB);
	}

}