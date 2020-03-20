package com.cdchen.winter.application;

import com.cdchen.winter.example.service.TestService;
import com.cdchen.winter.example.service.impl.TestServiceImpl;
import com.cdchen.winter.ioc.container.WinterContainer;

public class App {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        WinterContainer.start();
        TestService testService = (TestService) WinterContainer.getBean(TestServiceImpl.class);
        testService.a();
    }
}
