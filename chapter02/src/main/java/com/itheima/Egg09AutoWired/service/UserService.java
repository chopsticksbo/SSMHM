package com.itheima.Egg09AutoWired.service;

import com.itheima.Egg09AutoWired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// 1. 定义UserService实例
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void saveUser(){
        System.out.println("UserService成功执行saveUser()方法！");
        userDao.saveUser();
    }
}
