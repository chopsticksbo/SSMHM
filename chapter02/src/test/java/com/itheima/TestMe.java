package com.itheima;

import com.itheima.bean.ArrayDITeacher;
import com.itheima.bean.Person;
import com.itheima.bean.SampleTypes;
import com.itheima.bean.Student;
import com.itheima.dao.UserDaoImpl;
import com.itheima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestMe {

    public void main(String[] args) {
        System.out.println(new Date());
//        输出格式
//        Mon Mar 30 09:49:45 CST 2026
//        因此注入Date类型时，若看成简单类型，需要使用上面这种格式
    }

//    测试listDI
    @Test
    public void testListDI(){
        ApplicationContext context = new ClassPathXmlApplicationContext("listDI.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

//    测试数组DI
//    @Test
    public void testArrayDI(){
        ApplicationContext context = new ClassPathXmlApplicationContext("arrayDI.xml");
        ArrayDITeacher teacher = context.getBean("teacher", ArrayDITeacher.class);
        System.out.println(teacher);
    }


//    1. 测试简单Types
//    2. 对简单类型，使用property标签配置
//    3.property标签的属性值可以是常量，也可以是表达式,xml文件内部对应name属性 和 value属性
    @Test
    public void SimpleTypesTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SampleTypes sampleTypes = context.getBean("sampleTypes", SampleTypes.class);
        System.out.println(sampleTypes);
    }

//    级联测试
//    属性中包含复杂类型，需要使用ref标签引用
    @Test
    public void StudentJilianTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = context.getBean("student1", Student.class);
        System.out.println(student);
    }

//    程序测试之property配置bean中的简单属性
//    1.先写一个student类，包含username、age、password属性
//    2. 生成对应的setter和toString方法
//    3. 配置applicationContext.xml文件，将student类的实例化交由Spring容器管理
    @Test
    public void StudentPropertyTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }



    @Test
    public void testInsert(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl userDaoImpl = context.getBean("userDaoImpl", UserDaoImpl.class);
        userDaoImpl.save();

        UserService userService = context.getBean("userService", UserService.class);
        userService.saveUser();
    }

    @Test
    public void testid() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
