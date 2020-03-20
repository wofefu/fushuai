package com.example.demo.exception.handler;

import com.example.demo.exception.RestException;
import com.example.demo.exception.ToViewException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerConfig {
    @ExceptionHandler(ToViewException.class)
    public ModelAndView error(ToViewException be) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("msg", be.getMessage());
        return mv;
    }

    @ExceptionHandler(RestException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String error(RestException be) {
        return be.getMessage();
    }
}
