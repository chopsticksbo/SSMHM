package com.itheima;

import com.itheima.dao.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestHelloSpring {
    public static void main(String[] args){
        //加载applicationContext.xml配置文件初始化Spring容器
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取配置中名称为UserDao的Bean
        UserDao userDao=
                (UserDao)applicationContext.getBean("userDao");
        //调用save()方法
        userDao.save();
    }
}
