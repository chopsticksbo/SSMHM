package com.itheima.mapper;


import com.itheima.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    User findById(int id);
   int insertUser(User user);
    int updateUser(User user);
    int deleteUserById(int id);
}
