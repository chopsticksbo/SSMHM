package com.itheima.Egg07ConstructorFunc.bean;

public class UserStaticFactory {
    //    无参构造方法，若只有无参输出无法指定数值
    public static User createUser() {

        System.out.println("UserStaticFactory中创建User实例前的初始化工作！");
        //模拟实例化User之前执行的操作
        return new User();

    }

    //    添加有参构造方法
    public static User createUser(int id, String name) {

        System.out.println("UserStaticFactory中创建User实例的初始化工作！");
        return new User(id, name);
    }
}
