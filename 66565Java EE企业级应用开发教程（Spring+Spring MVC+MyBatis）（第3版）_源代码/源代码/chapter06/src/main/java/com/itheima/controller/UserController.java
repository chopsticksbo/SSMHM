package com.itheima.controller;

import com.itheima.pojo.Person;
import com.itheima.pojo.Product;
import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    public UserController() {
        System.out.println("---------------------------");
    }

    @RequestMapping("/findOrderWithUser")
    public void findOrderWithUser(User user) {
       /* String username = user.getUsername();
        String orderId = user.getOrder().getOrderId();
        System.out.println("username="+username+",orderId="+orderId);*/
    }
    /**
     * 获取单个用户信息
     */
    @RequestMapping("/saveUser")
    public void saveUser(@RequestBody User user) {
        String username = user.getUsername();
        String psw = user.getPassword();
        System.out.println("用户信息―姓名："+username+"；密码："+psw);
    }
    /**
     * 获取多个用户信息
     */
    @RequestMapping("/saveUserList")
    public void saveUserList(@RequestBody List<User> userList) {
        for (User user : userList) {
            String username = user.getUsername();
            String psw = user.getPassword();
            System.out.println("用户信息―姓名："+username+"；密码："+psw);
        }
    }
}
