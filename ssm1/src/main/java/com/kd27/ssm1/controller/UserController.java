package com.kd27.ssm1.controller;

import com.kd27.ssm1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/checkUsername")
    public Map<String, Object> checkUsername(String username){

        Map<String, Object> map = new HashMap<>();

        if(userService.isExists(username)){
            map.put("code", 1);
            map.put("msg", "用户名已存在");
        }else{
            map.put("code", "0");
            map.put("msg", "用户名可用");
        }

        return map;
    }
}
