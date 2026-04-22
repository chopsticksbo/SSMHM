package com.itheima.Egg01JdkProxy.dao;

// 公共接口，定义了动态代理的方法，需要在代理对象的方法中实现这些方法
public interface DynamicUserDao {
    void addUser();
    void deleteUser();
}
