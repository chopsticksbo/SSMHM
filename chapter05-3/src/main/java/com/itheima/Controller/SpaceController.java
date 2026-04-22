package com.itheima.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpaceController {
    @RequestMapping("/getSpacecraftName")
    // http://localhost:8081/chapter053/getSpacecraftName?spacecraftName="hhhhhhh"
    public String getSpacecraftName(HttpServletRequest request) {
        String spacecraftName = request.getParameter("spacecraftName");
        System.out.println(spacecraftName);  // output "hhhhh"
        return "ok";
    }

    @RequestMapping("/getSpacecraft")  // localhost:8081/chapter053/getSpacecraft?spacecraft="hhhhhhh"
    public void getSpacecraft(String spacecraft) {
        System.out.println(spacecraft);  // output "hhhhh"
    }

    @RequestMapping("/getSpacecraft1")  // localhost:8081/chapter053/getSpacecraft1?spacecraft1="hhhhhhh"
    public void getSpacecraft1(
            @RequestParam(value = "spacecraft1",required = true)  // spacecraft1=hhhhhhh
            String spacecraft1) {
        System.out.println(spacecraft1);  // output "hhhhh"
    }
}
