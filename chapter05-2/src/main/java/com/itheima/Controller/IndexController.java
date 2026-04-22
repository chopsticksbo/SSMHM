package com.itheima.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/sport")
    public String sport(){
        return "sport";
    }

    @RequestMapping("/finance")
    public String finance(){
        return "finance";
    }
}
