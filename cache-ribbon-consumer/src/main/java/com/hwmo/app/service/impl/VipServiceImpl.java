package com.hwmo.app.service.impl;

import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
	@Cacheable(cacheNames = "cache_orders", key = "#id")
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
		
		System.out.println("url========="+url.toString());
		String url2 = "http://ordersprovider/orders/"+id;
		//调用远程的服务
		//Orders orders = restTemplate.getForObject(url.toString(), Orders.class);
		//return orders;
		return restTemplate.getForObject(url2.toString(), Orders.class);
	}

	@Override
	@Cacheable(cacheNames = "cache_ordersList", key = "#root.methodName")
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

	}

	/**
	 * 定义返回托底数据的方法，实现服务降级
	 * @return
	 *//*
	public Orders fallBack01() {

		Orders orders = new Orders();
		orders.setId(-111);
		orders.setRemark("服务器繁忙，请稍后再试！");
		orders.setTotal(-22);
		return orders;
	}

	*//**
	 * 定义返回托底数据的方法，实现服务降级
	 * @return
	 *//*
	public List<Orders> fallBack02() {

		Orders orders = new Orders();
		orders.setId(-333);
		orders.setRemark("服务器繁忙，请稍后再试！");
		orders.setTotal(-444);

		List<Orders> lst = new ArrayList<Orders>();
		lst.add(orders);
		return lst;
	}*/
}
