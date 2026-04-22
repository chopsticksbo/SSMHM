package com.itheima;

import com.itheima.Egg06Scop.AppConfig;
import com.itheima.Egg06Scop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Egg06Test {
    @Test
    public void testScope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService1 = context.getBean(UserService.class);
        UserService userService2 = context.getBean(UserService.class);
        System.out.println(userService1);
        System.out.println(userService2);
    }
}
