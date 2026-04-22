package com.itheima.Egg01构造注入.service;


import com.itheima.Egg01构造注入.dao.OrderDao;
import com.itheima.Egg01构造注入.dao.UserDao;

public class OrderService {
    private OrderDao orderDao;
    private UserDao userDao;

    public OrderService() {
    }

    // 通过反射机制调用构造方法给属性赋值
    public OrderService(OrderDao orderDao, UserDao userDao) {
        this.orderDao = orderDao;
        this.userDao = userDao;
    }

    public void delete(){
        orderDao.deleteById();
        userDao.save();
    }
}
