package com.itheima.Egg06Scop;

import com.itheima.Egg06Scop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.itheima.Egg06Scop")
public class AppConfig {

    @Bean
//    @Scope("prototype")  // 每次创建一个新的对象
    // 输出如下：
    // com.itheima.Egg06Scop.service.UserService@7d373bcf
    //com.itheima.Egg06Scop.service.UserService@6d6bc1581
    @Scope("prototype") // 单例模式,两次创建的对象使用的是同一个对象，共用一个内存地址
    // 输出如下：
// com.itheima.Egg06Scop.service.UserService@560513ce
// com.itheima.Egg06Scop.service.UserService@560513ce
    public UserService userService() {
        return new UserService();
    }

}
