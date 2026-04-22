package com.itheima.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

//    @Override
    public void save() {
        System.out.println("UserDaoImpl save");
//        使用logger.info()方法记录日志
        logger.info("UserDaoImpl save");
    }
}
