//import com.itheima.Egg01JdkProxy.dao.CglibUserDao;
//import org.aopalliance.intercept.MethodInterceptor;
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
//public class CglibProxy implements MethodInterceptor {
//    private CglibUserDao target;
//    public Object createProxy(CglibUserDao target){
//        this.target=target;
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(target.getClass());
//        enhancer.setCallback(this);
//        Object proxy = enhancer.create();
//        return proxy;
//    }
//
//    @Override
//    public Object intercept(Object o, Method method,
//                            Object[] objects,
//                            MethodProxy methodProxy) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        Object result = methodProxy.invokeSuper(o, objects);
//        long endTime = System.currentTimeMillis();
//        System.out.println(method.getName() + "方法执行耗时：" + (endTime - startTime) + "毫秒");
//        return result;
//    }
//}