package com.profile.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan(basePackages = {"com.profile.model"})  
@SpringBootApplication
@EnableEurekaClient
public class ProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
	}

}
