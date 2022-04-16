package com.hwmo.app.service.impl;

import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.VipService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {

	//Ribbon提供的负载均衡器
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;
	@Override//个人总结：fallbackMethod时fallBack01方法时要与原方法有相同的参数，defaultMethod时不需要，否则报错
	@HystrixCommand(fallbackMethod = "fallBack01", commandProperties = {
			// 默认20个;10s内请求数大于10个时启动熔断，如果错误率没有50%不会触发fallBack01()。
			@HystrixProperty(
					name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,
					value = "10"),
			// 请求错误率大于50%时就熔断，然后for循环发起请求，当请求符合熔断条件时将触发fallBack01()。
			@HystrixProperty(
					name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,
					value = "50"),
			// 默认5秒;熔断多少秒后去尝试请求
			@HystrixProperty(
					name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,
					value = "5000")
	}
	)
	public Orders loadVipOrdersService(Integer id) {
		//通过制定需要调用的远程服务的名字获得服务实例对象
		//si中封装了远程服务的ip，端口等信息
		ServiceInstance si = loadBalancerClient.choose("ordersprovider");
		//http://localhost:2222/orders/888
		StringBuilder url=new StringBuilder();
		url.append("http://").append(si.getHost());
		url.append(":");
		url.append(si.getPort());
		url.append("/orders/").append(id);
		

		String url2 = "http://ordersprovider/orders/"+id;
		System.out.println("url========="+url2.toString());
		//调用远程的服务
		//Orders orders = restTemplate.getForObject(url.toString(), Orders.class);
		//return orders;

		if(id==1){
			throw new RuntimeException();
		}
		if(id==2){
			throw new RuntimeException();
		}

		return restTemplate.getForObject(url2.toString(), Orders.class);
	}

	/*@Override
	@HystrixCommand(defaultFallback = "fallBack02")
	public List<Orders> loadVipOrdersListService() {
		ServiceInstance si = loadBalancerClient.choose("ordersprovider");
		//http://localhost:2222/orders/888
		StringBuilder url=new StringBuilder();
		url.append("http://").append(si.getHost());
		url.append(":");
		url.append(si.getPort());
		url.append("/orders");
		System.out.println("url========="+url.toString());
		String url2 = "http://ordersprovider/orders";
		//调用远程的服务
		Orders[] orders = restTemplate.getForObject(url2.toString(), Orders[].class);
		if(orders != null){
			return Arrays.asList(orders);
		}else{
			return null;
		}

	}*/

	/**
	 * 定义返回托底数据的方法，实现服务降级
	 * @return
	 */
	public Orders fallBack01(Integer id) {
		System.out.println("fallBack01=========id:"+id);
		Orders orders = new Orders();
		orders.setId(-111);
		orders.setRemark("服务器繁忙，请稍后再试！");
		orders.setTotal(-22);
		return orders;
	}

	/**
	 * 定义返回托底数据的方法，实现服务降级
	 * @return
	 */
	public List<Orders> fallBack02() {

		Orders orders = new Orders();
		orders.setId(-333);
		orders.setRemark("服务器繁忙，请稍后再试！");
		orders.setTotal(-444);

		List<Orders> lst = new ArrayList<Orders>();
		lst.add(orders);
		return lst;
	}
}
