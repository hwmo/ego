package com.hwmo.app.service;

import com.hwmo.app.pojo.Orders;

import java.util.List;

public interface VipService {

	/***
	 * 查询会员的某个订单
	 */
	public Orders loadVipOrdersService(Integer id);
	/**
	 * 查询会员的所有订单
	 */
	public List<Orders> loadVipOrdersListService();
}
