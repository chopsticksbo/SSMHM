package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserDaoImpl;
import com.itheima.proxy.JdkProxy;

public class JdkTest{
	public static void main(String[] args) {
		// 创建代理类对象
		JdkProxy jdkProxy = new JdkProxy();
         // 创建目标对象
		UserDao userDao= new UserDaoImpl();
		// 获取增强的代理对象
		UserDao userDaoProxy = (UserDao) jdkProxy.createProxy(userDao);
		// 执行方法
		userDaoProxy .addUser();
		userDaoProxy .deleteUser();
	}
}