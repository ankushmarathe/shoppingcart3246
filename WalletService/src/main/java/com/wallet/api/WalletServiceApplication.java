package com.wallet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EntityScan(basePackages = {"com.wallet.api.model"})  
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class WalletServiceApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new  RestTemplate();
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	    return builder.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WalletServiceApplication.class, args);
	}

}
