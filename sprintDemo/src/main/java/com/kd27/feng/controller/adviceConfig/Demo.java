package com.kd27.feng.controller.adviceConfig;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Demo {
    @ExceptionHandler(RuntimeException.class)
    public String demo(RuntimeException e){
        System.out.println(e.toString());
        return "error";
    }
}
