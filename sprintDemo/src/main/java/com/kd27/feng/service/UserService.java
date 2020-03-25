package com.kd27.feng.service;

import com.kd27.feng.entity.LiveRoom;
import com.kd27.feng.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    User loginVerify(String username,String password);
    User selectUser(Integer user_id);
    User selectUserByName(String username);
    User selectUserById(int userId);
    void updateUser(User user);
    void registerUser(User user);
    void addRole(String roleName,Integer userId);
 }
