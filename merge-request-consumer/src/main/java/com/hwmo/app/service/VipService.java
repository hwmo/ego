package com.hwmo.app.service;

import java.util.List;

import com.hwmo.app.pojo.Orders;

public interface VipService {

	/**
	 * 查询会员的所有订单
	 */
	public List<Orders> loadVipOrdersListService(List<Integer> ids);
}
