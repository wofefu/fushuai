package com.fuhsuai.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        System.out.println("ExceptionHandlers.handleException：" + e.getMessage());
        return "500";
    }
}
