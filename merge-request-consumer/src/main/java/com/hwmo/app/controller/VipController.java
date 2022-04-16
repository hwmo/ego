package com.hwmo.app.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.hwmo.app.service.impl.VipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.VipService;

@RestController
public class VipController {

	//注入本地service对象
	@Autowired
	private VipServiceImpl vipService;
	

	/***
	 * 处理查询订单集合信息的请求
	 */
	@GetMapping("/vipo/{id}")
	public Orders loadVipOrdersList(@PathVariable(value = "id") Integer id) throws ExecutionException, InterruptedException {
		Orders order = null;
		System.out.println("consumer:-----------------------------");
		Future<Orders> future = vipService.futureOrder(id);
		Future<Orders> future2 = vipService.futureOrder(2);
		Future<Orders> future3 = vipService.futureOrder(3);
		Future<Orders> future4 = vipService.futureOrder(4);
		Future<Orders> future5 = vipService.futureOrder(5);
		order = future.get();

		return order;
	}
}
