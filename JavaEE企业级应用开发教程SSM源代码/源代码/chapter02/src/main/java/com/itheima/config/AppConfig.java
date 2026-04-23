package com.itheima.config;

import com.itheima.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class AppConfig {
    @Bean
/*    @Scope("singleton")*/
    @Scope("prototype")
    public User user() {
        return new User();
    }
}