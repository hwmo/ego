package com.hwmo.app.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EgoVipConfigs {

	/***
	 * 实例化RestTemplate模板对象
	 */
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	/***
	 * 通过实例化负载均衡策略对象，改变默认负载均衡策略
	 */
	@Bean
	public RandomRule randomRule() {
		return new RandomRule();
	}
}
