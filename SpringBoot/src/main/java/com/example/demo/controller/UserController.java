package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api("与用户相关")
public class UserController {
    @GetMapping("/user")
    @ResponseBody
    public String user(){
        return "success";
    }
}
