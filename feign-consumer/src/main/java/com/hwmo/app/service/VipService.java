package com.hwmo.app.service;

import java.util.List;

import com.hwmo.app.pojo.Orders;

public interface VipService {

	/**
	 * 查询会员的某个订单详情
	 */
	public Orders loadVipOrdersService(Integer id);
	/***
	 * 查询会员的所有订单
	 */
	public String loadVipOrdersListService();
}
