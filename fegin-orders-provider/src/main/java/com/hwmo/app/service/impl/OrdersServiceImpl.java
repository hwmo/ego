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
		o.setRemark("中午配送...8087");
		o.setTotal(123);
		return o;
	}

	@Override
	public String loadOrdersListService() {
		// TODO Auto-generated method stub
		List<Orders> results=new ArrayList<Orders>();
		
		Orders o=new Orders();
		o.setId(234);
		/*o.setRemark("中午配送...我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民" +
				"我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国共和国我爱中华人民共和国我爱中华" +
				"我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华" +
				"人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国共和国我爱中华人民共和国我爱中华人民共和国" +
				"我爱中华人民共和国我爱中华人民共和国人民共和国我爱中华人我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国共和国我爱中华人" +
				"民共和国我爱中华人民共和国我爱中华人民共和国我爱中华人民共和国民共和国我爱中华人民共和国");*/
		o.setRemark("noon");
		o.setTotal(123);
		
		/*Orders o2=new Orders();
		o2.setId(567);
		o2.setRemark("weekend");
		o2.setTotal(890);*/
		
		results.add(o);
		//results.add(o2);
		
		return "mwh";
	}

}
