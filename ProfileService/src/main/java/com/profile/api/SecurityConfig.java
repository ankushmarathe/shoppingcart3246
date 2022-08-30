package com.profile.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.profile.api.service.MyUserDeatilsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDeatilsService myUserDetailsService;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(getAuthProvider());
//		auth.inMemoryAuthentication()
//		.withUser("harry")
//		.password(getPassEncoder().encode("potter"))
//		.authorities("MANAGER")
//		.and()
//		.withUser("ronald")
//		.password(getPassEncoder().encode("weasley"))
//		.authorities("ACCOUNTANT");
		
	}
	private AuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(myUserDetailsService);
		auth.setPasswordEncoder(getPassEncoder());
		return auth;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
				.antMatchers(HttpMethod.POST,"/user").permitAll()
				.antMatchers(HttpMethod.GET,"/user").authenticated()
				.antMatchers(HttpMethod.GET,"/hello").permitAll()
				.antMatchers(HttpMethod.DELETE,"/user/{uid}").authenticated()
				.antMatchers(HttpMethod.PUT,"/user/update/{uid}").authenticated()
				.antMatchers("/hello1").hasAnyAuthority("MANAGER")
				.anyRequest().permitAll()
				.and()
				.httpBasic()
				.and()
				.csrf().disable();
				
	}
	@Bean
  public PasswordEncoder getPassEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	
	

}
