package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImplForMysql implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("删除mysql数据库中的用户");
    }
}
