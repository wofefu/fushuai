package com.example.app.controller;

import com.example.app.Exception.LoginException;
import com.example.app.entity.User;
import com.example.app.service.UserService;
import com.example.app.token.MyAppToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@Api(tags = "与登录有关")
public class LoginController {
    private final MyAppToken myAppToken;
    private final UserService userService;

    public LoginController(UserService userService, MyAppToken myAppToken) {
        this.userService = userService;
        this.myAppToken = myAppToken;
    }

    @PostMapping("/login")
    @ApiOperation("通过手机号和密码登陆")
    public String login(String phone, String password) {
        List<User> list = userService.findByPhoneAndPassword(phone, password);
        if (list.size() > 0) {
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            myAppToken.addToken(token);
            return token;
        } else {
            throw new LoginException("用户名或密码错误");
        }
    }

    @PostMapping("/test")
    @ApiOperation("验证令牌有效后进来")
    public String test() {
        return "令牌有效可以进来";
    }
}
