package com.itheima;

import com.itheima.Egg07ConstructorFunc.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Egg07Test {
    @Test
    public void TestConstruct(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Egg07.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
