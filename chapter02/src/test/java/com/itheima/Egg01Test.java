package com.itheima;

import com.itheima.Egg01构造注入.service.OrderService;
import com.itheima.bean.Person;
import com.itheima.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Egg01Test {
    @Test
    public void testDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Egg01.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        System.out.println(orderService);
        orderService.delete();
    }

    @Test
    public void testStudent(){
        BeanFactory context = new ClassPathXmlApplicationContext("Egg01.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testPerson(){
        BeanFactory context = new ClassPathXmlApplicationContext("arrayDI.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }
}
