package com.hwmo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //该项目是注册中心的客户端，vip-consumer项目的服务端，需要连接上注册中心
public class EgoOrdersServerApp {

	public static void main(String[] args) {
		SpringApplication.run(EgoOrdersServerApp.class, args);
	}

}
