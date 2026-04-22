package com.itheima.Egg01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/method")
public class MethodController {
    //处理请求方法为GET的请求
    @RequestMapping(method = RequestMethod.GET)
    public void get() {
        System.out.println("RequestMethod.GET");
    }
    //处理请求方法为DELETE的请求
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete() {
        System.out.println("RequestMethod.DELETE");
    }
    //处理请求方法为POST的请求
    @RequestMapping(method = RequestMethod.POST)
    public void post() {
        System.out.println("RequestMethod.POST");
    }
    //处理请求方法为PUT的请求
    @RequestMapping(method = RequestMethod.PUT)
    public void put() {
        System.out.println("RequestMethod.PUT");
    }
}