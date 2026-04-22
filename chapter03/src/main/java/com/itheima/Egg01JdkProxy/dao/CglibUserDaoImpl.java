package com.itheima.Egg01JdkProxy.dao;
import com.itheima.Egg01JdkProxy.dao.CglibUserDao;

public class CglibUserDaoImpl implements CglibUserDao {
    public void addUser() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("添加用户");
    }
    public void deleteUser() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("删除用户");
    }
  }
