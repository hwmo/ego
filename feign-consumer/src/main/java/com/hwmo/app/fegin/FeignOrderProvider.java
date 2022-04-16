package com.hwmo.app.fegin;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.hwmo.app.pojo.Orders;
//指定@FeignClient需要指定远程调用的服务的名字，产生接口的代理对象
@FeignClient(name="feign-orders-provider")
public interface FeignOrderProvider {

	/****
	 * 
	 * 该接口中的方法命名规范：
	 * 必须要和服务提供者Controller中的方法的签名一致
	 * 		url:  
	 * 		return:
	 * 		params:
	 * 和生产者的Controller的方法的声明保持一致
	 * 
	 * FeginClient :将一个远程服务伪装为本地对象进行调用
	 * 如果ribbon调用远程服务：
	 * 	 http://orders-provider/orders/1000
	 */
	/***
	 * 处理查询某个订单信息的请求
	 */
	@GetMapping("/orders/{id}")
	public Orders loadOrders(@PathVariable("id") Integer id);
	/***
	 * 处理查询某个会员订单集合的请求
	 */
	@GetMapping("/orders")
	public String loadOrdersList();
	
	/**单个参数传递方式一：*/
	@GetMapping("/params")
	public String params01(@RequestParam("params") String params);
	/**单个参数传递方式二：*/
	@GetMapping("/params/{params}")
	public String params02(@PathVariable("params") String params);
	/**单个参数传递方式三：*/
	@PostMapping("/params")
	public String params03(@RequestParam("params") String params);
	/**单个参数传递方式四：*/
	@PostMapping("/params/{params}")
	public String params04(@PathVariable("params") String params);

	@GetMapping("/mparams")
	public Orders params05(@RequestParam("id") Integer id, @RequestParam("remark") String remark,
						   @RequestParam("total") Integer total);

	@PostMapping("/mparams")
	public Orders params06(@RequestBody Orders orders);
}
