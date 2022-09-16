package com.profile.api.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.profile.api.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 *go to DB and check weather this username is present or not.
		 *if present fetch the userDetails
		 *if not present throws unsername notfoundexeption
		 */
		com.profile.api.model.User userDB= userRepository.findByUsername(username);
		if(userDB==null)
			throw new UsernameNotFoundException("Invalid Credentials");
		/*
		 * convert role to Authority
		 */
		List<GrantedAuthority> list = new ArrayList<>();
		String role = userDB.getRole();
		SimpleGrantedAuthority authority=  new SimpleGrantedAuthority(role);
		list.add(authority);
		/*
		 * pass user info from the DB to Spring internal user that takes
		 * username, password and list of genertedAuthority
		 */
		 User springUser = new User(userDB.getUsername(), userDB.getEncrytedPassword(),list);
		
		return springUser;
	}

}

