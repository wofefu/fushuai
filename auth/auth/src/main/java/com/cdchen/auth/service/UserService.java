package com.cdchen.auth.service;

import com.cdchen.auth.entity.User;

public interface UserService {

    User login(String username,String password);

    void register(String username,String password);

    User buyRole(Long userId,Long[] roleIds);
}
