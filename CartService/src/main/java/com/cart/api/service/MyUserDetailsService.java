package com.cart.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
=======
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
>>>>>>> f5386277197efb2ecb8fe16afd6d79919388916b
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
//import org.springframework.web.client.RestTemplate;

//import com.cart.api.repository.UserRepository;

//import com.cart.api.repository.UserRepository;
=======
import org.springframework.web.client.RestTemplate;

import com.cart.api.repository.UserRepository;
>>>>>>> f5386277197efb2ecb8fe16afd6d79919388916b



@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private com.cart.api.repository.UserRepository userRepository;
	
<<<<<<< HEAD
	//@Autowired
	//private RestTemplate restTemplate;
=======
	@Autowired
	private RestTemplate restTemplate;
>>>>>>> f5386277197efb2ecb8fe16afd6d79919388916b
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		// checking the details by making call to profile service because it is managing all the users.
<<<<<<< HEAD
		//ResponseEntity<com.cart.api.model.User> temp=restTemplate
			//	.getForEntity("http://localhost:1200/u/user/"+username, com.cart.api.model.User.class);
		//com.cart.api.model.User userDB=temp.getBody();
		
		
		com.cart.api.model.User userDB=userRepository.findByUsername(username);  
=======
		ResponseEntity<com.cart.api.model.User> temp=restTemplate
				.getForEntity("http://localhost:1200/u/user/"+username, com.cart.api.model.User.class);
		com.cart.api.model.User userDB=temp.getBody();
		
		
		//com.wallet.api.model.User userDB=userRepository.findByUsername(username);  
>>>>>>> f5386277197efb2ecb8fe16afd6d79919388916b
		 if(userDB==null) throw new UsernameNotFoundException("Invalid Username");
		 
				 
		 List<GrantedAuthority> list=new ArrayList<>();
		 SimpleGrantedAuthority sga=new SimpleGrantedAuthority(userDB.getRole());
		 list.add(sga);
		 
		 User springuser=new User(userDB.getusername(),userDB.getPassword(),list);
		return  springuser;
	}

}
