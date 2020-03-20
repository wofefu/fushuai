package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    //增强什么业务
    //aop 切点 是方法以上的范围  最小范围
    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    public void point() {

    }

    @Before("point()")
    public void start(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().toLongString());
        System.out.println("开始");
    }

    @After("point()")
    public void end(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().toLongString());
        System.out.println("结束");
    }

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开始");
        Object result = joinPoint.proceed();
        System.out.println("结束");
        return result;
    }

    @AfterReturning("point()")
    public void ar() {
        System.out.println("返回完后");
    }

    @AfterThrowing("point()")
    public void at() {
        System.out.println("抛出异常");
    }
}
