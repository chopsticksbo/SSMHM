package com.itheima.Egg10BeanLifeCycle.bean;



import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DataInfo {
    public DataInfo() {
        System.out.println("1.实例化Bean");
    }
    @PostConstruct
    private void initData(){
        System.out.println("初始化方法执行！");
    }
    @PreDestroy
    private void destroyData(){
        System.out.println("销毁方法执行！");
    }
}
