import com.itheima.Egg01JdkProxy.dao.*;
import com.itheima.Egg01JdkProxy.proxy.JdkProxy;
import com.itheima.Egg01JdkProxy.proxy.StaticProxy;
import com.itheima.Egg01JdkProxy.dao.DynamicUserDaoImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;


public class Egg01Test {
    @Test
    public void testSaveUser(){
        UserDao userDao = new UserDaoImpl();
        JdkProxy jdkProxy = new JdkProxy();
        UserDao proxy = (UserDao) jdkProxy.createProxy(userDao);
        long startTime = System.currentTimeMillis();
        proxy.addUser();
        long endTime = System.currentTimeMillis();
        System.out.println("添加用户耗时：" + (endTime - startTime) + "毫秒");
        proxy.deleteUser();
    }

//    测试动态代理
    @Test
    public void testDynamicProxy() {
//        正常调用添加用户和删除用户方法
        DynamicUserDao dynamicProxy = new DynamicUserDaoImpl();
        dynamicProxy.addUser();
        dynamicProxy.deleteUser();
        System.out.println("-----------------");
// 方法一
//        一.创建目标对象
        DynamicUserDao target = new DynamicUserDaoImpl();
//        二.创建代理对象
//        1. 调用Proxy类的newProxyInstance方法创建代理对象
//        2. 传递三个参数：目标对象的类加载器、目标对象的接口、动态代理对象
//        3. 返回值：代理对象
        DynamicUserDao proxyObj = (DynamicUserDao) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new DynamicTimerInvocationHandler(target));
//        三.调用代理对象的方法
        proxyObj.addUser();
        proxyObj.deleteUser();
        System.out.println("-----------------");


// 方法二，书上的方法
        DynamicUserDao target2 = new DynamicUserDaoImpl();
        DynamicTimerInvocationHandler2 dynamicTimerInvocationHandler2 = new DynamicTimerInvocationHandler2();
        DynamicUserDao proxyObj2 = (DynamicUserDao) dynamicTimerInvocationHandler2.createProxy(target2);
        proxyObj2.addUser();
        proxyObj2.deleteUser();

    }

// 测试静态代理
//    创建目标对象
//    创建代理对象
//    调用代理对象的方法
//    优点：在编译时就确定了代理对象，不需要在运行时动态创建代理对象
//    缺点：只能代理一个接口，不能代理多个接口，类太多的类会增加系统的复杂度，导致系统的维护成本增加
//    适用场景：在编译时就确定了代理对象，不需要在运行时动态创建代理对象
//    适用场景：在代理对象的方法中，需要在方法执行前后添加一些公共的代码
//    @Test
    public void testStaticProxy(){
//        正常调用添加用户和删除用户方法
        StaticUserDao staticUserDao1 = new StaticUserDaoImpl();
        staticUserDao1.addUser();
        staticUserDao1.deleteUser();
        System.out.println("-----------------");

//        使用静态代理测试添加用户和删除用户耗时
        StaticUserDao staticUserDao = new StaticUserDaoImpl();
        StaticProxy staticProxy = new StaticProxy(staticUserDao);
        staticProxy.addUser();
        staticProxy.deleteUser();
    }
}
