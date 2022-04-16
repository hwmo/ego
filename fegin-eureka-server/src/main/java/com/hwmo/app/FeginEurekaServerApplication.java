package com.hwmo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FeginEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeginEurekaServerApplication.class, args);
	}

}
