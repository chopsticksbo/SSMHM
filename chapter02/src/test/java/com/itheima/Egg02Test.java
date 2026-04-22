package com.itheima;

import com.itheima.Egg02其他注入方法.bean.注入Map和Properties;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Egg02Test {

    @Test
    public void testInjectMapAndProperties() {
        System.out.println("注入Map和Properties");
        ApplicationContext context = new ClassPathXmlApplicationContext("Egg02.xml");
        注入Map和Properties injectMapAndProperties = context.getBean("注入Map和Properties", 注入Map和Properties.class);
        System.out.println(injectMapAndProperties);
    }
}
