package com.hwmo.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hwmo.app.pojo.Orders;
import com.hwmo.app.service.OrdersService;
@Service
public class OrdersServiceImpl implements OrdersService {


	@Override
	public List<Orders> loadOrdersListService(Integer[] ids) {
		// TODO Auto-generated method stub
		List<Orders> results=new ArrayList<Orders>();
		Orders o = null;
		System.out.println("----------------order-provider:loadOrdersListService");
		for(Integer id : ids){
			o = new Orders();
			o.setId(id);
			o.setRemark("中午配送..."+id);
			o.setTotal(id * 10);
			results.add(o);
		}
		
//		Orders o=new Orders();
//
//
//		Orders o2=new Orders();
//		o2.setId(567);
//		o2.setRemark("周末配送...");
//		o2.setTotal(890);
//
//		results.add(o);
//		results.add(o2);
		
		return results;
	}

}
