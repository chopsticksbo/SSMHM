package com.itheima;


import com.itheima.pojo.DataInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
public class LifecycleTest {
    public static void main(String[] args) {
        //初始化容器
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.itheima");
        //获取Bean
        DataInfo dataInfo = (DataInfo)context.getBean("dataInfo");
        //关闭Spring应用程序上下文
        AbstractApplicationContext ac=(AbstractApplicationContext)context;
        ac.registerShutdownHook();
    }
}
