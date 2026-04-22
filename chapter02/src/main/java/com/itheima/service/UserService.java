package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    @Autowired
    private UserDaoImpl userDaoImpl;

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

/*    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public void saveUser(){
        System.out.println("UserService成功执行saveUser()方法！");
//        userDao.saveUser();
        userDaoImpl.save();
    }
}
