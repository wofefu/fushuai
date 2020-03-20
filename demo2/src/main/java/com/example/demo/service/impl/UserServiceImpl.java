package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.enums.RoleType;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String username, String password) {
        return userMapper.findByUsernameAndPassword(username,password);
    }

    @Override
    public void addManger(String phone, String password) {
        User user = new User();
        user.setUsername(phone);
        //可能需要加密
        user.setPassword(password);
        user.setRole(RoleType.SHOP_MANAGER);
        userMapper.insert(user);
    }
}
