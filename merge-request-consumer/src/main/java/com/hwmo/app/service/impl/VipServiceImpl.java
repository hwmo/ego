package com.hwmo.app.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.VipService;

@Service
public class VipServiceImpl implements VipService {

	//Ribbon提供的负载均衡器
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCollapser(batchMethod = "loadVipOrdersListService",
	scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
	collapserProperties = {
			@HystrixProperty(name="timerDelayInMilliseconds", value = "20"),
			@HystrixProperty(name = "maxRequestsInBatch", value = "200")
	})
	public Future<Orders> futureOrder(Integer id){
		System.out.println("00000000000000000000000000");
		return null;
	}

	@Override
	@HystrixCommand
	public List<Orders> loadVipOrdersListService(List<Integer> ids) {
		System.out.println("-------------------------------------------");
		Integer[] idArray = ids.toArray(new Integer[]{});
		String param = Arrays.toString(idArray);
		param=param.replace("[", "ids=");
		param=param.replace("]", "");
		param=param.replace(",", "&ids=");
		System.out.println("-------------------------------------------"+param);
		String url2 = "http://ordersprovider/orders?"+param;
		//调用远程的服务
		Orders[] orders = restTemplate.getForObject(url2.toString(), Orders[].class);
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
	/*public List<Orders> fallBack() {

		Orders orders = new Orders();
		orders.setId(-333);
		orders.setRemark("服务器繁忙，请稍后再试！");
		orders.setTotal(-444);

		List<Orders> lst = new ArrayList<Orders>();
		lst.add(orders);
		return lst;
	}*/
}
