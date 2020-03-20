package com.cdchen.auth.controller;

import com.cdchen.auth.auth.annotation.HasAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiamondController {
    @GetMapping("/red")
    @HasAuth(roles = "RED")
    public String red() {
        return "红钻用户可以进入";
    }

    @GetMapping("/yellow")
    @HasAuth(roles = "YELLOW")
    public String yellow() {
        return "黄钻用户可以进入";
    }

    @GetMapping("/green")
    @HasAuth(roles = "GREEN")
    public String green() {
        return "绿钻用户可以进入";
    }

    @GetMapping("/both")
    @HasAuth(roles = "DIAMOND")
    public String diamond() {
        return "所有开钻用户可以进入";
    }

    @GetMapping("/redOrYellow")
    @HasAuth(roles = {"RED", "YELLOW"})
    public String redOrYellow() {
        return "红钻/黄钻用户可以进入";
    }


    @GetMapping("/redOrGreen")
    @HasAuth(roles = {"RED", "GREEN"})
    public String redOrGreen() {
        return "红钻/绿钻用户可以进入";
    }

    @GetMapping("/greenOrYellow")
    @HasAuth(roles = {"GREEN", "YELLOW"})
    public String greenOrYellow() {
        return "绿钻/黄钻用户可以进入";
    }


}
