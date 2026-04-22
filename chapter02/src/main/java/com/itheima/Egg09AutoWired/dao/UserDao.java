package com.itheima.Egg09AutoWired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void saveUser(){
        System.out.println("UserDao saveUser");
    }
}
