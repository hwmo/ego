package com.hwmo.app.feign;

import com.hwmo.app.pojo.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ordersprovider", fallback = FeignBreakerProviderImpl.class)
public interface FeignBreakerProvider {

    @GetMapping("/orders/{id}")
    public Orders loadOrders(@PathVariable("id") Integer id);
    /***
     * 处理查询某个会员订单集合的请求
     */
    @GetMapping("/orders")
    public List<Orders> loadOrdersList();
}
