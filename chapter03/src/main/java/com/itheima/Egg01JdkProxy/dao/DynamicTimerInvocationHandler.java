package com.itheima.Egg01JdkProxy.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 方法一实现动态代理
// 专门负责计时的调用处理对象，只需要写一次即可
public class DynamicTimerInvocationHandler implements InvocationHandler {
//    目标对象
    private Object target;
    // 构造方法
    public DynamicTimerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //        记录方法执行开始时间
        long startTime = System.currentTimeMillis();
        //        调用目标对象的方法
        Object result = method.invoke(target, args);
        //        记录方法执行结束时间
        long endTime = System.currentTimeMillis();
        //        打印方法执行耗时
        System.out.println(method.getName() + "方法执行耗时：" + (endTime - startTime) + "毫秒");
        //        返回方法执行结果
        return result;
    }
}


