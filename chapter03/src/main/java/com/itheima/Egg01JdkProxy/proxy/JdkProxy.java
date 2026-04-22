package com.itheima.Egg01JdkProxy.proxy;

import com.itheima.Egg01JdkProxy.dao.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import com.itheima.Egg01JdkProxy.aspect.MyAspect;

public class JdkProxy implements InvocationHandler {
    private UserDao userDao;
    public  Object createProxy(UserDao userDao){
        this.userDao = userDao;
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        Class[] clazz =userDao.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, clazz, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.checkPermissions();
        Object result = method.invoke(userDao, args);
        myAspect.log();
        return result;
    }
}
