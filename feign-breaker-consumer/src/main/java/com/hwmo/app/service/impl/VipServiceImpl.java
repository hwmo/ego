package com.hwmo.app.service.impl;

import com.hwmo.app.feign.FeignBreakerProvider;
import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {

	@Autowired
	private FeignBreakerProvider breakerProvider;//注入feign接口的远程代理对象

	@Override
	public Orders loadVipOrdersService(Integer id) {
		return breakerProvider.loadOrders(id);
	}

	@Override
	public List<Orders> loadVipOrdersListService() {
		return breakerProvider.loadOrdersList();

	}

}
