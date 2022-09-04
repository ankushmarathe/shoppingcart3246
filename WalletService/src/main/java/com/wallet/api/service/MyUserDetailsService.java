package com.wallet.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.wallet.api.repository.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		// checking the details by making call to profile service because it is managing all the users.
		ResponseEntity<com.wallet.api.model.User> temp=restTemplate
				.getForEntity("http://localhost:1200/u/user/"+username, com.wallet.api.model.User.class);
		com.wallet.api.model.User userDB=temp.getBody();
		
		
		//com.wallet.api.model.User userDB=userRepository.findByUsername(username);  
		 if(userDB==null) throw new UsernameNotFoundException("Invalid Username");
		 
				 
		 List<GrantedAuthority> list=new ArrayList<>();
		 SimpleGrantedAuthority sga=new SimpleGrantedAuthority(userDB.getRole());
		 list.add(sga);
		 
		 User springuser=new User(userDB.getUsername(),userDB.getPassword(),list);
		return  springuser;
	}

}
