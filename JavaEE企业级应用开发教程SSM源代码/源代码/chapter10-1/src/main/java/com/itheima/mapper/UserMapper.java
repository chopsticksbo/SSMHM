package com.itheima.mapper;

import com.itheima.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Select(" SELECT * FROM user WHERE id = #{id}")
    User findById(int id);
    @Insert("INSERT INTO user (username) VALUES (#{username})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
   int insertUser(User user);
    @Update("UPDATE user SET username = #{username} WHERE id = #{id}")
    int updateUser(User user);
    @Delete("DELETE FROM user WHERE id = #{id}")
    @Options
    int deleteUserById(int id);
}
