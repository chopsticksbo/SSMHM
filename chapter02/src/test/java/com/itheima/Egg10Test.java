package com.itheima;




import com.itheima.Egg10BeanLifeCycle.bean.DataInfo;
import com.itheima.Egg10BeanLifeCycle.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Egg10Test {
    @Test
    public void testLifecycle(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Egg10.xml");
        User userBean = applicationContext.getBean("user", User.class);
        System.out.println("4.使用Bean");
        // 只有正常关闭spring容器才会执行销毁方法
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void testDataInfo(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.itheima.Egg10BeanLifeCycle.bean");
        DataInfo dataInfo = applicationContext.getBean("dataInfo", DataInfo.class);
        AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext) applicationContext;
        abstractApplicationContext.registerShutdownHook();
    }
}

