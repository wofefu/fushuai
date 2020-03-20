package com.cdchen.winter.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WinterBeanProxy<T> implements InvocationHandler {

    private T t;

    public WinterBeanProxy(T t) {
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强了");
        return method.invoke(t,args);
    }
}
