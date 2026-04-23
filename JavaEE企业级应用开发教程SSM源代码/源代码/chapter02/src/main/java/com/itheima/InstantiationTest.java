package com.itheima;

import com.itheima.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class InstantiationTest {
    public static void main(String[] args) {
        //加载applicationContext.xml配置文件初始化Spring容器
        ApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=(User)context.getBean("user");
        System.out.println(user);
    }
}
