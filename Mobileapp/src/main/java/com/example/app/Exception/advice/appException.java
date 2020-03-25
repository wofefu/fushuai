package com.example.app.Exception.advice;

import com.example.app.Exception.CheckException;
import com.example.app.Exception.LoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class appException {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(LoginException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String loginException(LoginException e){
        logger.error("登录日志",e);
         return e.getMessage();
    }

    @ExceptionHandler(CheckException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public String CheckException(LoginException e){
        logger.error("检查令牌日志",e);
        return e.getMessage();
    }
}
