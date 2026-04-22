package com.itheima.Controller;

import com.itheima.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpResponse;
import java.util.Arrays;

@Controller
public class UserController {
    @RequestMapping("/")
    public String testRegister() {
        return "register";
    }
//    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    @PostMapping("/user/register")
    public String register(HttpServletRequest request,
                           HttpServletResponse response,
                           HttpSession session
                           ) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
//        获取注册页面的参数username、password、gender、hobby、introduction
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String[] hobby = request.getParameterValues("hobby");
        String introduction = request.getParameter("introduction");
        System.out.println(username);
        System.out.println(password);
        System.out.println(gender);
        System.out.println(hobby);
        System.out.println(introduction);
        return "ok";
    }

    @PostMapping("/user/register2")
    public String register2(@RequestParam(value = "username",defaultValue = "默认值") String username,
                            @RequestParam("password") String password,
                            @RequestParam(value = "gender", required = false) String gender,
                            @RequestParam(value = "hobby", required = false) String[] hobby,
                            @RequestParam(value = "introduction", required = false) String introduction){
        System.out.println(username);
        System.out.println(password);
        System.out.println(gender);
        System.out.println(Arrays.toString(hobby));
        System.out.println(introduction);
        return "ok";
    }

    @PostMapping("/user/register3")
//    @RequestMapping("/user/register3",method = {RequestMethod.POST,RequestMethod.GET})
    public String register3(User user) {
        System.out.println(user);
        return "ok";
    }

}