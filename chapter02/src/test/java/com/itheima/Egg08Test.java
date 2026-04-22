package com.itheima;

import com.itheima.Egg08WiredFunc.Service.UserService;
import com.itheima.Egg08WiredFunc.Service.UserService2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Egg08Test {
    @Test
    public void testSaveUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Egg08.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.saveUser();
    }

    @Test
    public void testSaveUser2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Egg08.xml");
        UserService2 userService2 = applicationContext.getBean("userService2", UserService2.class);
        userService2.saveUser();
    }
}
