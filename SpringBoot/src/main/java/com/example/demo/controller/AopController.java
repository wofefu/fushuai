package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {
    @GetMapping("/aop")
    public void test(){
        System.out.println("核心业务");
    }
}
