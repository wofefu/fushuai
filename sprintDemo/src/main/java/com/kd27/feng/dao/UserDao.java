package com.kd27.feng.dao;


import com.kd27.feng.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User login(@Param("username") String username, @Param("password") String password);
    User selectUser(Integer id);
    User selectUserByName(String username);
    void update(@Param("user") User user);
    void register(@Param("user") User user);
}
