package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    /**
     * 登录业务 如果登录成功返回用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    User login(String username, String password);

    /**
     * 超级管理员添加经理账户
     *
     * @param phone    手机号
     * @param password 密码
     */
    void addManger(String phone, String password);
}
