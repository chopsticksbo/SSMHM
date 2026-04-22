package com.itheima;


import com.itheima.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {
    public static void main(String[] args) {
        //初始化容器
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.itheima");
        //获取名称为user的Bean
        UserService userService = (UserService)context.getBean("userService");
        userService.saveUser();
    }
}
