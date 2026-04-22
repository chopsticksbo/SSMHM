package com.itheima.test;


import com.itheima.dao.Student;
import com.itheima.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class MyTest {

    @Test
    public void testStudent(){
//        超级工厂模式，ApplicationContext继承BeanFactory
        BeanFactory context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);

//        使用日志
        Logger logger = Logger.getLogger(Student.class.getName());
        logger.info("这是一条info日志");
//        logger.warning("这是一条warning日志");
//        logger.severe("这是一条severe日志");
//        logger.config("这是一条config日志");
//        logger.fine("这是一条fine日志");

    }

    @Test
    public void testSave(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.save();
    }
}
