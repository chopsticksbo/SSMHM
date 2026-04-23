package com.itheima.controller;

import com.itheima.pojo.Spacecraft;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
public class SpaceController{
    /**
     *默认支持类型绑定
     */
    @RequestMapping("/getSpacecraftName")
    public void getSpacecraftName(HttpServletRequest request) throws UnsupportedEncodingException {
        String spaceName= request.getParameter("spaceName");
        System.out.println(spaceName);
    }
    /**
     *简单数据类型绑定
     */
    @RequestMapping( "/getSpacecraft")
    public void getSpacecraft(int number,String name){
        System.out.println("编号："+number+"；名称："+name);
    }
    /**
     *简单数据类型绑定：使用@RequestParam注解
     */
    @RequestMapping("/getSpace")
    public void getSpace(@RequestParam(value="nm",
            required = false,defaultValue = "天宫二号")String name){
        System.out.println("名称："+name);
    }

    /**
     *简单数据类型绑定：REST风格
     */
    @RequestMapping("/space/{name}")
    public void getPathVariable(@PathVariable(value = "name")
                                String spaceName){
        System.out.println("名称："+spaceName);
    }

    /**
     *POJO类型绑定
     */
    @RequestMapping("/launch")
    public void launch(Spacecraft spacecraft) {
        System.out.println(spacecraft);
    }
/*    @RequestMapping("/launchDate")
    public void launchDate (Date date) {
        System.out.println("发射日期："+date);
    }*/

    /**
     *自定义类型转换
     */
    @RequestMapping("/launchDate")
    public void launchDate (@DateTimeFormat(
            pattern = "yyyy-MM-dd")Date date) {
        System.out.println("发射日期："+date);
    }

    /**
     *数组绑定
     */
    @RequestMapping("/batchLaunch")
    public void batchLaunch(String[] names) {
        for (String name:names) {
            System.out.print(name+"  ");
        }
    }
    /**
     *集合绑定
     */
    @RequestMapping("/batchLaunch02")
    public void batchLaunchForList(@RequestParam List<String> names) {
        for (String name:names) {
            System.out.print(name+"  ");
        }
    }
}