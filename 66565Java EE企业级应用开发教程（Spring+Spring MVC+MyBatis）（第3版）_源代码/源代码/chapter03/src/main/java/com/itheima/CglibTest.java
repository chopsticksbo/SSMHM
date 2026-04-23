package com.itheima;

import com.itheima.dao.OrderDao;
import com.itheima.proxy.CglibProxy;
public class CglibTest {
	public static void main(String[] args) {
		// 创建代理类对象
		CglibProxy cglibProxy = new CglibProxy();
        // 创建目标对象
		OrderDao orderDao = new OrderDao();
         // 获取增强后的目标对象
		OrderDao orderDaoProxy = (OrderDao)cglibProxy.createProxy(orderDao);
		// 执行方法
		orderDaoProxy.addOrder();
		orderDaoProxy.deleteOrder();
	}
}