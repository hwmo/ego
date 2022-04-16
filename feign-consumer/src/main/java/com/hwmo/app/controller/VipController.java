package com.hwmo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hwmo.app.fegin.FeignOrderProvider;
import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.VipService;

@RestController
public class VipController {

	
	@Autowired
	private VipService vipService;
	
	@Autowired
	private FeignOrderProvider feignOrderProvider;
	
	/***
	 * 处理加载会员某个订单详的请求
	 */
	@GetMapping("/vipo/{id}")
	public Orders loadVipOrders(@PathVariable("id") Integer id) {
		return vipService.loadVipOrdersService(id);
	}
	/***
	 * 处理加载会员订单集合的请求
	 */
	@GetMapping("/vipo")
	public String loadVipOrdersList(){
		//List<Orders> orders =  vipService.loadVipOrdersListService();
	String s = vipService.loadVipOrdersListService();
		return s;
	}
	
	/**单个参数传递方式一：*/
	@GetMapping("/cparams")
	public String cparams01(@RequestParam("params") String params) {
		return feignOrderProvider.params01(params);
	}
	/**单个参数传递方式二：*/
	@GetMapping("/cparams/{params}")
	public String cparams02(@PathVariable("params") String params) {
		return feignOrderProvider.params02(params);
	}
	/**单个参数传递方式三：*/
	@PostMapping("/cparams")
	public String cparams03(@RequestParam("params") String params) {
		return feignOrderProvider.params03(params);
	}
	/**单个参数传递方式四：*/
	@PostMapping("/cparams/{params}")
	public String cparams04(@PathVariable("params") String params) {
		return feignOrderProvider.params04(params);
	}

	@GetMapping("/cmparams")
	public Orders cparams05(Orders orders){
		System.out.println("c----------------多个参数传递一："+orders.getRemark());
		Orders o = feignOrderProvider.params05(orders.getId(),orders.getRemark(),orders.getTotal());

		return o;
	}

	@PostMapping("/cmparams")
	public Orders cparams06(Orders orders){
		System.out.println("c----------------多个参数传递二："+orders.getRemark());
		Orders o = feignOrderProvider.params06(orders);

		return o;
	}
}
