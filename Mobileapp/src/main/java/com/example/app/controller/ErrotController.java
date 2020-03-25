package com.example.app.controller;

import com.example.app.Exception.CheckException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrotController {

    @GetMapping("/error")
    public void accessError(){
        throw new CheckException("无效凭证");
    }
}
