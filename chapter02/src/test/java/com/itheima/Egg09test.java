package com.itheima;

import com.itheima.Egg09AutoWired.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Egg09test {
    @Test
    public void testSaveUser(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.itheima.Egg09AutoWired");
        UserService userService = context.getBean(UserService.class);
        userService.saveUser();
    }
}
