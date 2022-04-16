package com.hwmo.app.controller;

import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VipController {

	//注入本地service对象
	@Autowired
	private VipService vipService;
	
	/***
	 * 处理查询某个订单详细信息的请求
	 */
	@GetMapping("/vipo/{id}")
	public Orders loadVipOrders(@PathVariable Integer id) {
		return vipService.loadVipOrdersService(id);
	}
	/***
	 * 处理查询订单集合信息的请求
	 */
	@GetMapping("/vipo")
	public List<Orders> loadVipOrdersList(){
		return vipService.loadVipOrdersListService();
	}
}
