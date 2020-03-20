package com.example.demo.controller;

import com.example.demo.dto.Validation;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class ValidationController {
    //hibernate的参数校验
    @GetMapping("/Validation")
    public  String create(@NotNull(message = "用户名不能为空") String username,@NotNull String password){
        return password+username;
    }

    @GetMapping("/num")
    public String num(@Range(min=1,max=100) int num,@Length(max = 5) String msg){
        return num+msg;
    }
    @GetMapping("/phone")
    public String phone(@Pattern(regexp = "1[3456789][0-9]{9}",message = "需要合法手机号") String phone){
        return phone;
    }
    //传对象
    @GetMapping("/validation")
    public Validation validation(@Validated Validation validation){
        return validation;
    }
}
