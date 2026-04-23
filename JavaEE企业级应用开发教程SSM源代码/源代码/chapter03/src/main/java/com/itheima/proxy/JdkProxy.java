package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import com.itheima.aspect.MyAspect;
import com.itheima.dao.UserDao;

/**
 * JDK代理类
 */
public class JdkProxy implements InvocationHandler{
	// 目标类接口
	private UserDao userDao;
	// 创建代理的方法
	public  Object createProxy(UserDao userDao) {
		this.userDao = userDao;
		// 1.获取类加载器
		ClassLoader classLoader = JdkProxy.class.getClassLoader();
		// 2.获取被代理对象实现的所有接口
		Class[] clazz = userDao.getClass().getInterfaces();
		// 3.获取代理对象
		return  Proxy.newProxyInstance(classLoader,clazz,this);
	}
	/*
	 * 所有动态代理类的方法调用，都会交由invoke()方法去处理
	 * proxy 被代理后的对象 
	 * method 将要被执行的方法信息
	 * args 执行方法时需要的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
                                                                throws Throwable {
		// 创建切面对象
		MyAspect myAspect = new MyAspect();
		// 前增强
		myAspect.checkPermissions();
		// 在目标类上调用方法，并传入参数
		Object obj = method.invoke(userDao, args);
		// 后增强
		myAspect.log();
		return obj;
	}
}