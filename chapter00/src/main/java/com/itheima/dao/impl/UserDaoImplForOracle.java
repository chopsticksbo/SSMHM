package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImplForOracle implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("Oracle正在删除用户");
    }
}
