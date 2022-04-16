package com.hwmo.app.feign;

import com.hwmo.app.pojo.Orders;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeignBreakerProviderImpl implements FeignBreakerProvider {


    @Override
    public Orders loadOrders(Integer id) {

        Orders orders = new Orders();
        orders.setId(id);
        orders.setRemark("服务器繁忙，请稍后再试！");
        orders.setTotal(-22);
        return orders;
    }

    @Override
    public List<Orders> loadOrdersList() {
        Orders orders = new Orders();
        orders.setId(-333);
        orders.setRemark("服务器繁忙，请稍后再试！");
        orders.setTotal(-444);

        List<Orders> lst = new ArrayList<Orders>();
        lst.add(orders);
        return lst;
    }
}
