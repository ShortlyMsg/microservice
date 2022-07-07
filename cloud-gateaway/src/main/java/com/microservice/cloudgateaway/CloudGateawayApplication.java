package com.microservice.cloudgateaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGateawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGateawayApplication.class, args);
	}

}
