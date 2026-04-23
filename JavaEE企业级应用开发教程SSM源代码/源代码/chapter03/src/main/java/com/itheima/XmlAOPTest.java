package com.itheima;

import com.itheima.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class XmlAOPTest {
    public static void main(String args[]) {
        //加载配置文件初始化Spring容器
        ApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // 1 从Spring容器获得内容
        UserDao userDao = (UserDao) context.getBean("userDao");
        // 2 执行方法
        userDao.addUser();
        System.out.println();
        userDao.deleteUser();
    }
}
