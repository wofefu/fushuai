package com.cdchen.winter.example.service.impl;

import com.cdchen.winter.example.service.TestService;
import com.cdchen.winter.ioc.annotation.Managed;

@Managed
public class TestServiceImpl implements TestService {
    @Override
    public void a() {

        System.out.println("a");

    }

    @Override
    public void b() {
        System.out.println("b");
    }
}
