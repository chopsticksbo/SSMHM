package com.itheima.Example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

//    请求映射路径为/test
//    返回值为first
//    方法名hehe
    @RequestMapping("/test")
    public String hehe(){
        System.out.println("hello world");
        return "first";
//        解析为WEB-INF/templates/first.html
    }

    @RequestMapping("/test2")
    public String haha(){
        System.out.println("hello world2");
        return "other";
    }
}
