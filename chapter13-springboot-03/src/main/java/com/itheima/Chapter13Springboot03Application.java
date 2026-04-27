package com.itheima;

import com.itheima.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Chapter13Springboot03Application {

    @Bean
    public Date getNowDate(){ // 方法名作为bean的id
        return new Date();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Chapter13Springboot03Application.class, args);

//        Date date = context.getBean(Date.class);
//        System.out.println("当前时间：" + date);

        Object sqlSessionFactory = context.getBean("sqlSessionFactory");
        System.out.println("当前数据库连接池的sqlSessionFactory：" + sqlSessionFactory);

        Object transactionManager = context.getBean("transactionManager");
        System.out.println("事务管理器：" + transactionManager);

//        context.close();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.findUser());


//        context.close();
    }
}
