package com.hwmo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.OrdersService;

@RestController
public class OrdersController  {
	//httpclient=http+json
	
	@Autowired
	private OrdersService ordersService;
	/***
	 * 处理查询某个订单信息的请求
	 */
	@GetMapping("/orders/{id}")
	public Orders loadOrders(@PathVariable("id") Integer id) {
		return ordersService.loadOrdersService(id);
	}
	/***
	 * 处理查询某个会员订单集合的请求
	 */
	@GetMapping("/orders")
	public String loadOrdersList(){
		return ordersService.loadOrdersListService();
	}
	
	/**单个参数传递方式一：*/
	@GetMapping("/params")
	public String params01(@RequestParam("params") String params) {
		return "单个参数传递方式一:"+params;
	}
	/**单个参数传递方式二：*/
	@GetMapping("/params/{params}")
	public String params02(@PathVariable("params") String params) {
		return "单个参数传递方式二:"+params;
	}
	/**单个参数传递方式三：*/
	@PostMapping("/params")
	public String params03(@RequestParam("params") String params) {
		return "单个参数传递方式三:"+params;
	}
	/**单个参数传递方式四：*/
	@PostMapping("/params/{params}")
	public String params04(@PathVariable("params") String params) {
		return "单个参数传递方式四:"+params;
	}


	@GetMapping("/mparams")
	public Orders params05(@RequestParam("id") Integer id, @RequestParam("remark") String remark, @RequestParam("total") Integer total){
		Orders order = new Orders();
		order.setId(id);
		order.setRemark("s---多个参数传递方法一:"+remark);
		order.setTotal(total);

		return order;
	}

	@PostMapping("/mparams")
	public Orders params06(@RequestBody Orders orders){

		orders.setRemark("s---多个参数传递方法二:" + orders.getRemark());
		return  orders;
	}
}
