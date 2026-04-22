package com.itheima.Egg08WiredFunc.Service;

import com.itheima.Egg08WiredFunc.dao.UserDao;

public class UserService2 {
    private UserDao userDao;

    public UserService2(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser() {
        System.out.println("构造注入 UserService成功执行saveUser()方法！");
        userDao.saveUser();
    }
}