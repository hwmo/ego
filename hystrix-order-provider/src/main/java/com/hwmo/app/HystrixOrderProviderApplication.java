package com.hwmo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HystrixOrderProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixOrderProviderApplication.class, args);
	}

}
