package com.profile.api.controller;

import java.security.Principal;
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

import com.profile.api.model.AppUser;
import com.profile.api.repository.UserRepository;


@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	
	
	//@Autowired
	//private PasswordEncoder passwordEncoder;

	/*
	 * @GetMapping("/hello") public String gethello() {
	 * 
	 * return "hello user"; }
	 */
	// post method to add new user
	
	
	@GetMapping("/gitlogin")
	public String message(Principal principal) {
		return "Hi "+principal.getName()+" welcome to SpringCloudOauth2ExampleApplication";
	}
	
	@GetMapping("/user")
	public String message1(Principal principal) {
		return "Hi "+principal.getName()+" welcome ";
	}
	
	/*
	 * @PostMapping("/users")
	 * 
	 * @ApiOperation(value="registration of new user", response=User.class) public
	 * User adduser(@RequestBody User user) { //String passEncoded =
	 * passwordEncoder.encode(user.getPassword()); //user.setPassword(passEncoded);
	 * return userRepository.save(user); }
	 */

	// get method to get all users list
	@GetMapping("/user1")
	public List<AppUser> getalluser() {

		return userRepository.findAll();
	}

	// delete method to delete user using user ID
	@DeleteMapping("/user/{uid}")
	public void deleteuser(@PathVariable("uid") Long uid) {
		userRepository.deleteById(uid);
	}

	
	@GetMapping("/user/{username}")
	public AppUser getByUsername(@PathVariable("username") String username) {
		
		AppUser user= userRepository.findByUsername(username);
	    
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
	public AppUser getByUserId(@PathVariable("id") long id) {
		
		AppUser user= userRepository.getById(id);
	
		return user;
	}
	
	// put method to update user according to user ID
	@PutMapping("/user/update/{uid}")
	public AppUser updateuser(@PathVariable("uid") Long uid, @RequestBody AppUser newuser) {

		AppUser userDB = userRepository.getById(uid);

		if (newuser.getFirstName() != null)
			userDB.setFirstName(newuser.getFirstName());

		if (newuser.getLastName() != null)
			userDB.setLastName(newuser.getLastName());
		
		if (newuser.getUserName() != null)
			userDB.setUserName(newuser.getUserName());

		/*
		 * if (newuser.getMobilenumber() != null)
		 * userDB.setMobilenumber(newuser.getMobilenumber());
		 */

		/*
		 * if (newuser.getGender()!= null) userDB.setGender(newuser.getGender());
		 */

		if (newuser.getEncrytedPassword()!= null)
			userDB.setEncrytedPassword(newuser.getEncrytedPassword());
		

		/*
		 * if (newuser.getEmail()!= null)
		 * userDB.setDateOfBirth(newuser.getDateOfBirth());
		 */
		if (newuser.getEmail() != null)
			userDB.setEmail(newuser.getEmail());
		/*
		 * if (newuser.getUsername() != null) userDB.setUsername(newuser.getUsername());
		 */

		return userRepository.save(userDB);
	}
	
	

}