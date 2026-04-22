package com.itheima.Egg05ConfigrationBean.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

// 1. 标记这是一个配置类（替代 XML）
@Configuration
// 2. 告诉 Spring 去扫描 com.example.service 包及其子包
// 凡是包里有 @Service, @Component 的类，都会被自动注册为 Bean
@ComponentScan(basePackages = "com.itheima.Egg05ConfigrationBean.bean,com.itheima.Egg05ConfigrationBean.service")
public class AppConfig {
    // 这里暂时是空的，主要靠 @ComponentScan 自动扫描
//    public AppConfig() {
//        System.out.println("AppConfig");
//    }
    @Bean
    public UserDao userDao() {
        return new UserDao();
    }
    @Bean
    public Person person() {
        return new Person();
    }
}
