package com.itheima.Egg01JdkProxy.proxy;

import com.itheima.Egg01JdkProxy.dao.StaticUserDao;

public class StaticProxy implements StaticUserDao {
//    静态代理
//    使用公共接口，耦合度低
    private StaticUserDao target;
//    构造方法
    //创建代理对象，传入被代理对象
    public StaticProxy(StaticUserDao target) {
        this.target = target;
    }

    @Override
    public void addUser() {
        long begin = System.currentTimeMillis();
        target.addUser();
        long end = System.currentTimeMillis();
        System.out.println("静态代理添加用户耗时：" + (end - begin));
    }

    @Override
    public void deleteUser() {
        long begin = System.currentTimeMillis();
        target.deleteUser();
        long end = System.currentTimeMillis();
        System.out.println("静态代理删除用户耗时：" + (end - begin));
    }

}
