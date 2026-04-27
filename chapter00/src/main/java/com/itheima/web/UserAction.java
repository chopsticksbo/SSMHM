package com.itheima.web;

import com.itheima.service.UserService;
import com.itheima.service.UserServiceImpl;

public class UserAction {
    //    表示层
    private UserService userService = new UserServiceImpl();
//    private UserService userService;
    public void deleteRequest() {
        userService.deleteUser();
    }
}
