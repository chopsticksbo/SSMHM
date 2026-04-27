package com.itheima;

import com.itheima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chapter13Springboot03ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void testFindUser() {
        System.out.println(userService.findUser());
    }

}
