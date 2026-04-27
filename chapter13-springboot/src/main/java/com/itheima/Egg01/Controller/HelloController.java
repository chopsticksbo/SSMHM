package com.itheima.Egg01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello(){
        return "你好呀，嘻嘻嘻。。。。。。。";
    }
}
