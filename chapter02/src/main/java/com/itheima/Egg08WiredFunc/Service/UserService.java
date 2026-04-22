package com.itheima.Egg08WiredFunc.Service;

import com.itheima.Egg08WiredFunc.dao.UserDao;

public class UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void saveUser(){
        System.out.println("setter注入 UserService成功执行saveUser()方法！");
        userDao.saveUser();
    }
}
