package com.hwmo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//此消费端用hystrix-order-provider作为服务端
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//启用服务熔断机制
public class BreakerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreakerConsumerApplication.class, args);
	}

}
