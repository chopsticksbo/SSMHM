package com.itheima.step03bxc;

import com.itheima.step02ywc.UserService;

public class UserAction {
    private UserService userService = new UserService();
    public void deleteUser(String zhanghao,String mima) {
        userService.deleteUser(zhanghao,mima);
    }
}
