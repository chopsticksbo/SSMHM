package com.itheima.service;

import com.itheima.dao.impl.UserDaoImplForMysql;
import com.itheima.dao.impl.UserDaoImplForOracle;
import com.itheima.service.UserService;

import com.itheima.dao.UserDao;
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImplForMysql();
//    private UserDao userDao = new UserDaoImplForOracle();
//    private UserDao userDao;
    @Override
    public void deleteUser() {
//        System.out.println("删除用户");

        userDao.deleteById();
        // 其他代码
    }
}
