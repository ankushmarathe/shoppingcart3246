//package com.shoppingcartgateway.api;
//
//import org.aspectj.weaver.ast.And;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////import com.springbootdemoo.service.MyUserDetailsService;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
////	@Autowired
////	private MyUserDetailsService myUserDetailsService;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//auth.authenticationProvider(getAuthProvider());
//		auth.inMemoryAuthentication()
//				.withUser("ankush")
//				.password(getPassEncoder().encode("ankushhhh"))
//				.authorities("MANAGER")
//				.and()
//				.withUser("vicky")
//				.password(getPassEncoder().encode("123"))
//				.authorities("ACCOUNTANT");
//				
//	}
//	
////	private AuthenticationProvider getAuthProvider() {
////		DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
////		auth.setUserDetailsService(myUserDetailsService);
////		auth.setPasswordEncoder(getPassEncoder());
////		return auth;
////	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//						.antMatchers(HttpMethod.POST,"/user").permitAll()
//						.antMatchers(HttpMethod.GET,"/wallet/a").permitAll()
//						.antMatchers(HttpMethod.GET,"/wallet/b").authenticated()
//						//.antMatchers("/employee").permitAll()
//						//.antMatchers("/employee/department").permitAll()
//						//.antMatchers("/employee").hasAnyAuthority("MANAGER")
//						.anyRequest().permitAll()
//						.and().httpBasic()
//						.and().csrf().disable();
//	}
//	
//	@Bean
//	public PasswordEncoder getPassEncoder(){
//		PasswordEncoder encoder=new BCryptPasswordEncoder();
//		return encoder;
//	}
//}
