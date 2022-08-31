//package com.wallet.api.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.wallet.api.repository.UserRepository;
//
//
//
//@Service
//public class MyUserDetailsService implements UserDetailsService{
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		com.wallet.api.model.User userDB=userRepository.findByUsername(username);
//		 if(userDB==null) throw new UsernameNotFoundException("Invalid Username");
//		 
//		 List<GrantedAuthority> list=new ArrayList<>();
//		 SimpleGrantedAuthority sga=new SimpleGrantedAuthority(userDB.getRole());
//		 list.add(sga);
//		 
//		 User springuser=new User(userDB.getusername(),userDB.getPassword(),list);
//		return  springuser;
//	}
//
//}
