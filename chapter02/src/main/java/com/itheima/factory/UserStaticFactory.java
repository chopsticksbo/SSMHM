package com.itheima.factory;

import com.itheima.pojo.User;
public class UserStaticFactory {
    public static User createUser(){
        //模拟实例化User之前执行的操作
        System.out.println("UserStaticFactory中创建User实例前的初始化工作！");
        return new User();
    }
}
