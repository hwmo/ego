package com.hwmo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication//此消费端用hystrix-order-provider作为服务端
@EnableEurekaClient
@EnableHystrix
public class ThreadConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreadConsumerApplication.class, args);
	}

}
