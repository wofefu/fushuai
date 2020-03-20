package com.cdchen.winter.ioc.container;


import com.cdchen.winter.aop.proxy.WinterBeanProxy;
import com.cdchen.winter.ioc.annotation.Managed;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.MethodParameterNamesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WinterContainer {

    private static Map<Class<?>, Object> beans = new HashMap();

    public static Object getBean(Class<?> s) {
        return beans.get(s);
    }

    public static void start() throws IllegalAccessException, InstantiationException {
        //容器启动 扫描项目中所有含有指定注解的类 创建实例并注入成员

        Reflections reflections = new Reflections("com.cdchen.winter.*",
                new MethodAnnotationsScanner(),
                new TypeAnnotationsScanner(),
                new SubTypesScanner(),
                new MethodParameterNamesScanner());

        //扫描所有带Managed注解的类 并创建对象
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Managed.class);
        for (Class<?> c : classSet) {

            //创建代理对象
            beans.put(c,
                    Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                            c.getInterfaces(),
                            new WinterBeanProxy(c.newInstance())));
        }

        //创建代理对象？

    }

    public static void main(String[] args) {

    }
}
