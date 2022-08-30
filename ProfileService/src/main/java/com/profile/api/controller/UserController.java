package com.profile.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * @GetMapping("/hello") public String gethello() {
	 * 
	 * return "hello user"; }
	 */
	// post method to add new user
	@PostMapping("/user")
	public User adduser(@RequestBody User user) {
		String passEncoded = passwordEncoder.encode(user.getPassword());
		user.setPassword(passEncoded);
		return userRepository.save(user);
	}

	// get method to get all users list
	@GetMapping("/user")
	public List<User> getalluser() {

		return userRepository.findAll();
	}

	// delete method to delete user using user ID
	@DeleteMapping("/user/{uid}")
	public void deleteuser(@PathVariable("uid") Long uid) {
		userRepository.deleteById(uid);
	}

	
	@GetMapping("/user/{username}")
	public User getByUsername(@PathVariable("username") String username) {
		
		User user= userRepository.findByUsername(username);
	    
		return user;	
	}
	
	/*
	 * @GetMapping("/user/{mobilenumber}") public User
	 * getByUsermobile(@PathVariable("mobilenumber") String mobilenumber) {
	 * 
	 * User user= userRepository.findByMobilenumber(mobilenumber);
	 * 
	 * return user; }
	 */
	
	@GetMapping("/user/{id}")
	public User getByUserId(@PathVariable("id") long id) {
		
		User user= userRepository.getById(id);
	
		return user;
	}
	
	// pur method to update user according to user ID
	@PutMapping("/user/update/{uid}")
	public User updateuser(@PathVariable("uid") Long uid, @RequestBody User newuser) {

		User userDB = userRepository.getById(uid);

		if (newuser.getFullName() != null)
			userDB.setFullName(newuser.getFullName());

		if (newuser.getAbout() != null)
			userDB.setAbout(newuser.getAbout());
		
		if (newuser.getRole() != null)
			userDB.setRole(newuser.getRole());

		if (newuser.getMobilenumber() != null)
			userDB.setMobilenumber(newuser.getMobilenumber());

		if (newuser.getGender()!= null)
			userDB.setGender(newuser.getGender());
		

		if (newuser.getPassword()!= null)
			userDB.setPassword(newuser.getPassword());
		

		if (newuser.getDateOfBirth()!= null)
			userDB.setDateOfBirth(newuser.getDateOfBirth());
		
		if (newuser.getEmailId() != null)
			userDB.setEmailId(newuser.getEmailId());
		if (newuser.getUsername() != null)
			userDB.setUsername(newuser.getUsername());

		return userRepository.save(userDB);
	}
	
	

}