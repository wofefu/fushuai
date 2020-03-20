package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hi/{uid}/{sid}")
    public String hello(@PathVariable Integer uid, @PathVariable Integer sid) {
        return "hi";
    }
}
