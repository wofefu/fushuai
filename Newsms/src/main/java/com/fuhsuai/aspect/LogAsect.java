package com.fuhsuai.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class LogAsect {
    @Pointcut("within(com.fuhsuai..*)")
    public void pc(){}

    @Before("pc()")
    public void before(JoinPoint p){
        MethodSignature method = (MethodSignature) p.getSignature();
        Class<?> declaringClass = method.getMethod().getDeclaringClass();
        Logger logger = LoggerFactory.getLogger(declaringClass);
        logger.trace(declaringClass.getName() + "#" + method.getName() + "start at " + new Date() + " with " + Arrays.toString(p.getArgs()));
    }

    @AfterReturning(value = "pc()", returning = "r")
    public void afterReturning(JoinPoint p, Object r){
        MethodSignature method = (MethodSignature) p.getSignature();
        Class<?> declaringClass = method.getMethod().getDeclaringClass();
        Logger logger = LoggerFactory.getLogger(declaringClass);
        logger.trace(declaringClass.getName() + "#" + method.getName() + "end at " + new Date() + " with " + r);
    }

    @AfterThrowing(value = "pc()", throwing = "e")
    public void afterThrowing(JoinPoint p, Throwable e){
        MethodSignature method = (MethodSignature) p.getSignature();
        Class<?> declaringClass = method.getMethod().getDeclaringClass();
        Logger logger = LoggerFactory.getLogger(declaringClass);
        logger.error(declaringClass.getName() + "#" + method.getName() + "throw at " + new Date() + " with " + e.getMessage());
    }
}
