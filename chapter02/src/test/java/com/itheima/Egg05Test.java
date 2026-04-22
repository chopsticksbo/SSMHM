package com.itheima;

import com.itheima.Egg05ConfigrationBean.bean.AppConfig;
import com.itheima.Egg05ConfigrationBean.bean.Person;
import com.itheima.Egg05ConfigrationBean.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Egg05Test {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        System.out.println(applicationContext);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.addUser();
        applicationContext.close();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }
}
