package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MyDateController {
    @Autowired
    private Date date;

    @RequestMapping("/hello")
    public String hello() {
        return date.toString();
    }
}
