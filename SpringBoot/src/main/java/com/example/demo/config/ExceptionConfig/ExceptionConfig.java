package com.example.demo.config.ExceptionConfig;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;


@RestControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
   public String validation(ConstraintViolationException e){
       return e.getLocalizedMessage();
   }
    @ExceptionHandler(BindException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String validation(BindException e){
        //List<ObjectError> list=e.getAllErrors();
        //for (ObjectError objectError : list) {
        //    System.out.println(objectError.getObjectName());
        //    System.out.println(objectError.getDefaultMessage());
        //}
        List<FieldError> list=e.getFieldErrors();
        String msg="";
        for (FieldError fieldError : list) {
            msg+=fieldError.getField()+fieldError.getDefaultMessage()+"\n";
        }
        return msg;
    }
}
