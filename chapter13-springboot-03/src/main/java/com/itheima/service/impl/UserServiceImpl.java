package com.itheima.service.impl;

import com.itheima.bean.User;
import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User findUser() {
        return new User("admin", "123456");
    }
}