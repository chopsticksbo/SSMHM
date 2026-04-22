package com.itheima.Egg01Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController2 {
//    @RequestMapping("/inde?2")
//    @RequestMapping("/index2")
    @RequestMapping("/index2")
    public String index() {
        return "index2";
    }

    @RequestMapping(value = {"/test", "/test2"})
    public String test() {
        return "test";
    }

//    @RequestMapping(value = "/test3", method = RequestMethod.POST)
//    public String test3login() {
//        System.out.println("test3login");
//        return "ok";
//    }
//    以上代码可用另一种方式写
//    @PostMapping("/test3")
@PostMapping("/tes?3")   // tesq3,tesy3,tesr3
    public String test3login() {
        System.out.println("test3login");
        return "ok";
    }

    @RequestMapping(value = "/test4param",params = {"username","password"})
    public String test4param() {
        System.out.println("test4param");
        return "ok";
    }


}
