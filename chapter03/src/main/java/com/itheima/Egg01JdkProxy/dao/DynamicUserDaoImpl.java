package com.itheima.Egg01JdkProxy.dao;

public class DynamicUserDaoImpl implements DynamicUserDao {
    @Override
    public void addUser() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("动态代理添加用户");
    }

    @Override
    public void deleteUser() {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("动态代理删除用户");
    }
}
