package com.hwmo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//此消费端用hystrix-order-provider作为服务端
@EnableEurekaClient
@EnableFeignClients
public class FeignBreakerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignBreakerConsumerApplication.class, args);
	}

}
