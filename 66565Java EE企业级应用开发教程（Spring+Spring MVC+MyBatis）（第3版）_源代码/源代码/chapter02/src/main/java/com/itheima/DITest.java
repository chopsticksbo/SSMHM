package com.itheima;


import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.
        support.ClassPathXmlApplicationContext;

public class DITest {
    public static void main(String[] args) {
        //加载applicationContext.xml配置文件初始化Spring容器
        ApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService)context.getBean("userService");
        userService.saveUser();
    }
}
