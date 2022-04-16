package com.hwmo.app.service.impl;

import java.util.Arrays;
import java.util.List;

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
	@Override
	public Orders loadVipOrdersService(Integer id) {
		//通过制定需要调用的远程服务的名字获得服务实例对象
		//si中封装了远程服务的ip，端口等信息
		/*ServiceInstance si = loadBalancerClient.choose("ordersprovider");
		//http://localhost:2222/orders/888
		StringBuilder url=new StringBuilder();
		url.append("http://").append(si.getHost());
		url.append(":");
		url.append(si.getPort());
		url.append("/orders/").append(id);*/
		
		//System.out.println("url========="+url.toString());
		String url2 = "http://ordersprovider/orders/"+id;
		//调用远程的服务
		//Orders orders = restTemplate.getForObject(url.toString(), Orders.class);
		//return orders;
		return restTemplate.getForObject(url2.toString(), Orders.class);
	}

	@Override
	public List<Orders> loadVipOrdersListService() {
		ServiceInstance si = loadBalancerClient.choose("ordersprovider");
		//http://localhost:2222/orders/888
	/*	StringBuilder url=new StringBuilder();
		url.append("http://").append(si.getHost());
		url.append(":");
		url.append(si.getPort());
		url.append("/orders");
		System.out.println("url========="+url.toString());*/
		String url2 = "http://ordersprovider/orders";
		//调用远程的服务
		Orders[] orders = restTemplate.getForObject(url2.toString(), Orders[].class);
		if(orders != null){
			return Arrays.asList(orders);
		}else{
			return null;
		}

	}

}
