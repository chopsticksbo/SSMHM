package com.itheima.controller;

import com.itheima.pojo.Order;
import com.itheima.pojo.Product;
import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Controller
public class OrderController {
    @RequestMapping("/saveOrders")
    public void saveOrders(User user) {
        List<Order> orders = user.getOrders();
        for (Order order:orders) {
            System.out.println("订单Id："+order.getOrderId());
        }
        List<String> addressList = user.getAddress();
        System.out.println("订单地址："+addressList);
    }
    @RequestMapping("/orderInfo")
    public void saveOrderInfo(Order order) {
        String orderId = order.getOrderId();		//获取订单Id
        System.out.println("订单Id："+orderId);
        //获取商品信息
        HashMap<String,Double> orderInfo = order.getProductInfo();
        Set<String> keys = orderInfo.keySet();
        System.out.println("订单商品信息如下");
        for (String name : keys) {
            Double price = orderInfo.get(name);
            System.out.println( "商品名称："+name+
                    "；商品价格："+price);
        }
    }
}