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
	private UserRepository  userRepository;
	
	
	//add new user 
	@PostMapping("/user")
	public User adduser( @RequestBody User user) {
		
		
		return userRepository.save(user);
	}
	
	//get  all users
	@GetMapping("/user")
	public List<User> getAllStaff(){
		
		return userRepository.findAll();
	}
	
	//delete user using user ID
	@DeleteMapping("/user/{uid}")		
	public void deleteStaff(@PathVariable("uid") Long uid) {
		userRepository.deleteById(uid);
		}
	
	//update user according to user ID
	@PutMapping("/user/update/{uid}")
	public User updateUser(@PathVariable("uid") Long uid, @RequestBody User Newuser) {
		
		User userDB= userRepository.getById(uid);
		
		if(Newuser.getName() !=null) 
			userDB.setName(Newuser.getName());
			
		if(Newuser.getAddress() !=null) 
			userDB.setAddress(Newuser.getAddress());
		if(Newuser.getRole() !=null) 
			userDB.setRole(Newuser.getRole());
					
		if(Newuser.getMobile() !=null) 
			userDB.setMobile(Newuser.getMobile());
						
		if(Newuser.getAge() !=0) 
			userDB.setAge(Newuser.getAge());
			
		if(Newuser.getEmail() !=null) 
			userDB.setEmail(Newuser.getEmail());
		
		return userRepository.save(userDB);
}
}