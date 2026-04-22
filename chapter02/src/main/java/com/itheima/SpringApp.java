package com.itheima;

import com.itheima.config.AppConfig;
import com.itheima.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        //加载配置文件初始化容器
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        //获取名称为user的Bean
        User u1 = (User)context.getBean("user");
        User u2 = (User)context.getBean("user");
        System.out.println("u1和u2是否为相同实例："+u1.equals(u2));
    }
}
