package com.hwmo.app.service.impl;

import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.VipService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
	@Override
	@HystrixCommand
	(
			//给provider提供的服务进行线程池分组,如果groupKey一样，运行在同一个线程池
			groupKey = "orders-provider",
			//指定需要调用的provider接口的方法名字
			commandKey = "loadVipOrdersService",
			//给线程池起名字
			threadPoolKey = "orders-provider",
			threadPoolProperties = {
					//线程池大小
					@HystrixProperty(name = "coreSize", value = "10"),
					//最大队列长度,正数表示阻塞队列
					@HystrixProperty(name = "maxQueueSize",value = "20"),
					//线程存活时间
					@HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
					//拒绝请求
					@HystrixProperty(name = "queueSizeRejectionThreshold", value = "15")
			},
			//熔断回调方法
			fallbackMethod = "fallBack01"//用fallbackMethod指定时，fallBack01(Integer id)方法要定义参数，defaultFallback指定时,fallBack01()不需要方法不需要定义参数
	)
	public Orders loadVipOrdersService(Integer id) {
		System.out.println("loadVipOrdersService----------------------------线程名：" + Thread.currentThread().getName());
		String url2 = "http://ordersprovider/orders/"+id;
		//调用远程的服务
		//Orders orders = restTemplate.getForObject(url.toString(), Orders.class);
		//return orders;
		return restTemplate.getForObject(url2.toString(), Orders.class);
	}

	@Override
	@HystrixCommand
	(
			//给provider提供的服务进行线程池分组,如果groupKey一样，运行在同一个线程池
			groupKey = "orders-provider",
			//指定需要调用的provider接口的方法名字
			commandKey = "loadVipOrdersListService",
			//给线程池起名字
			threadPoolKey = "orders-provider",
			threadPoolProperties = {
					//线程池大小
					@HystrixProperty(name = "coreSize", value = "1"),
					//最大队列长度,正数表示阻塞队列
					@HystrixProperty(name = "maxQueueSize",value = "1"),
					//线程存活时间
					@HystrixProperty(name = "keepAliveTimeMinutes", value = "1"),
					//拒绝请求
					@HystrixProperty(name = "queueSizeRejectionThreshold", value = "1")
			},
			//熔断回调方法
			fallbackMethod = "fallBack02"//用fallbackMethod指定时，fallBack01(Integer id)方法要定义参数，defaultFallback指定时,fallBack01()不需要方法不需要定义参数
	)
	public List<Orders> loadVipOrdersListService() {

		String url2 = "http://ordersprovider/orders";
		//调用远程的服务
		Orders[] orders = restTemplate.getForObject(url2.toString(), Orders[].class);
		System.out.println("loadVipOrdersListService----------------------------线程名：" + Thread.currentThread().getName());
		if(orders != null){
			return Arrays.asList(orders);
		}else{
			return null;
		}

	}

	/**
	 * 定义返回托底数据的方法，实现服务降级
	 * @return
	 */
	public Orders fallBack01(Integer id) {

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
