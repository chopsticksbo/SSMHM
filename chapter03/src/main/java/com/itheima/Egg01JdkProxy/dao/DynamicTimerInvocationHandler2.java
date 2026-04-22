package com.itheima.Egg01JdkProxy.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//方法二，书上的方法
public class DynamicTimerInvocationHandler2 implements InvocationHandler {
    // 目标对象
    private DynamicUserDao target;
//    创建代理的方法
    public  Object createProxy(DynamicUserDao target){
        this.target = target;
        // 1. 获取类加载器对象
        ClassLoader classLoader = target.getClass().getClassLoader();
        // 2. 获取接口对象
        Class[] clazz = target.getClass().getInterfaces();
        // 3. 创建代理对象
        return Proxy.newProxyInstance(classLoader, clazz, this);
    }

//    调用代理对象的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //        记录方法执行开始时间
        long startTime = System.currentTimeMillis();
        //        调用目标对象的方法
        Object result = method.invoke(target, args);  //主执行方法
        //        记录方法执行结束时间
        long endTime = System.currentTimeMillis();
        //        打印方法执行耗时
        System.out.println(method.getName() + "方法执行耗时：" + (endTime - startTime) + "毫秒");
        //        返回方法执行结果
        return result;
    }
}
