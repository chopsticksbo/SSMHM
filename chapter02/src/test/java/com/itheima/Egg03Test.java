package com.itheima;

import com.itheima.Egg03Annotation.Component;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Egg03Test {

    static void main(String[] args) throws ClassNotFoundException {
//        反射机制读取注解
        Class<?> clazz = Class.forName("com.itheima.Egg03Annotation.bean.User");
        if(clazz.isAnnotationPresent(Component.class)){
            Component component = clazz.getAnnotation(Component.class);
            System.out.println(component);
            System.out.println(component.value());
        }
    }

//    组件扫描，扫描指定包下的所有组件类,包含@Component注解的类,实例化该对象，并存储到Map集合中
    @Test
    public void testComponentScan() {

        Map<String, Object> map = new HashMap<>();

        String path = "com.itheima.Egg03Annotation.bean";
//        开始扫描程序
        String packagePath = path.replace(".", "/");
        System.out.println(packagePath);
        URL url = ClassLoader .getSystemClassLoader().getResource(packagePath);
        String path1 = url.getPath();
        System.out.println("path1 = " + path1);
        File file = new File(path1);
        File[] files = file.listFiles();

        Arrays.stream(files).forEach(file1 -> {
            try{
                String className = file1.getName().split("\\.")[0];
                System.out.println(className);

                String className1 = path + "." + className;
                System.out.println(className1);

                Class<?> clazz = Class.forName(className1);
                if (clazz.isAnnotationPresent(Component.class)){
                    Component component = clazz.getAnnotation(Component.class);
                    String id = component.value();
                    System.out.println(component);
                    System.out.println("id = " + id);
                    Object obj = clazz.newInstance();
                    System.out.println(obj);
                    map.put(id, obj);
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        });
        System.out.println(map);
    }

}
