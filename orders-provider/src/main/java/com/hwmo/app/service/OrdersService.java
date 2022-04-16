package com.hwmo.app.service;

import java.util.List;

import com.hwmo.app.pojo.Orders;

public interface OrdersService {
	
	/***
	 * 查询某个订单的详细信息
	 */
	public Orders loadOrdersService(Integer id);
	/***
	 * 查询某个用户订单集合信息
	 */
	public List<Orders> loadOrdersListService();
}
