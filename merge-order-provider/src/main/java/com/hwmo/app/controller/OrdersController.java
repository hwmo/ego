package com.hwmo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.OrdersService;

@RestController
public class OrdersController {
	//httpclient=http+json
	
	@Autowired
	private OrdersService ordersService;
	/***
	 * 处理查询某个订单信息的请求
	 */
	@GetMapping("/orders")
	public List<Orders> loadOrders(@RequestParam("ids") Integer[] ids) {
		System.out.println("/orders=======================");
		return ordersService.loadOrdersListService(ids);
	}

}
