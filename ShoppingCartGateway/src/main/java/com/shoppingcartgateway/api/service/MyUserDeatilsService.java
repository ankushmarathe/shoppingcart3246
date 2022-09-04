//package com.shoppingcartgateway.api.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//
//
//
//
//
//@Service
//public class MyUserDeatilsService implements UserDetailsService{
//
//
//	
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		/*
//		 *go to DB and check weather this username is present or not.
//		 *if present fetch the userDetails
//		 *if not present throws unsername notfoundexeption
//		 */
//		System.out.println(username);
//		RestTemplate restTemplate=new RestTemplate();
//		
//		com.shoppingcartgateway.api.model.User userDB=restTemplate.getForObject("http://localhost:1000/user/hello/"+username, com.shoppingcartgateway.api.model.User.class);
//		
//		//com.shoppingcartgateway.api.model.User userDB= userRepository.findByUsername(username);
//		if(userDB==null)
//			throw new UsernameNotFoundException("Invalid Credentials");
//		/*
//		 * convert role to Authority
//		 */
//		List<GrantedAuthority> list = new ArrayList<>();
//		String role = userDB.getRole();
//		SimpleGrantedAuthority authority=  new SimpleGrantedAuthority(role);
//		list.add(authority);
//		/*
//		 * pass user info from the DB to Spring internal user that takes
//		 * username, password and list of genertedAuthority
//		 */
//		 User springUser = new User(userDB.getUsername(), userDB.getPassword(),list);
//		
//		return springUser;
//	}
//
//}