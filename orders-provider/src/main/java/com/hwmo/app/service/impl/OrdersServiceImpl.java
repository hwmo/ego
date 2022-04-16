package com.hwmo.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.OrdersService;
@Service
public class OrdersServiceImpl implements OrdersService {

	@Override
	public Orders loadOrdersService(Integer id) {
		// TODO Auto-generated method stub
		Orders o=new Orders();
		o.setId(id);
		o.setRemark("中午配送...");
		o.setTotal(123);
		return o;
	}

	@Override
	public List<Orders> loadOrdersListService() {
		// TODO Auto-generated method stub
		List<Orders> results=new ArrayList<Orders>();
		
		Orders o=new Orders();
		o.setId(234);
		o.setRemark("中午配送...");
		o.setTotal(123);
		
		Orders o2=new Orders();
		o2.setId(567);
		o2.setRemark("周末配送...");
		o2.setTotal(890);
		
		results.add(o);
		results.add(o2);
		
		return results;
	}

}
