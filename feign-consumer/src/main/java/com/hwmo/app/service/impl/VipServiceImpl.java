package com.hwmo.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwmo.app.fegin.FeignOrderProvider;
import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.VipService;
@Service
public class VipServiceImpl implements VipService {

	//注入feign接口的远程代理对象
	@Autowired
	private FeignOrderProvider feignOrderProvider;
	
	@Override
	public Orders loadVipOrdersService(Integer id) {
		// TODO Auto-generated method stub
		//完成远程服务调用，和调用本地方法一样
		return feignOrderProvider.loadOrders(id);
	}

	@Override
	public String loadVipOrdersListService() {
		// TODO Auto-generated method stub
		return feignOrderProvider.loadOrdersList();
	}

}
