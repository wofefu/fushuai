package com.cdchen.auth.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public String handle(RuntimeException e, Model model) {
        model.addAttribute("errMsg",e.getMessage());
        return "error";
    }
}
