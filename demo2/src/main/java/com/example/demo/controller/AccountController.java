package com.example.demo.controller;

import com.example.demo.annotation.HasRole;
import com.example.demo.exception.RestException;
import com.example.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final UserMapper userMapper;

    public AccountController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/check")
    @HasRole({"SUPER_ADMIN", "SHOP_MANAGER"})
    public void checkPhone(String phone) {
        if (userMapper.findByUsername(phone) != null) {
            throw new RestException("手机号已存在");
        }

    }
}
