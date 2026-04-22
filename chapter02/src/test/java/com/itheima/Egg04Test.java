package com.itheima;

import com.itheima.Egg04AnnotationExample.bean.*;
import com.itheima.Egg04AnnotationExample.service.A;
import com.itheima.Egg04AnnotationExample.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Egg04Test {

    @Test
    public void testA() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Egg04.xml");
//        A a = applicationContext.getBean("a", A.class);
//        System.out.println(a);
//        System.out.println(a);
    }



    @Test
    public void testUser() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Egg04.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
        Vip vip = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vip);
        Student student = applicationContext.getBean("studentBean", Student.class);
        System.out.println(student);
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println(order);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
    }

    @Test
    public void testTeacher() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Egg04.xml");
        Teacher teacher = applicationContext.getBean("teacher", Teacher.class);
        System.out.println(teacher);
    }
}
