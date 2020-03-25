package com.example.app.token;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyAppToken {
    private Set<String> list=new HashSet<>();

    public void addToken(String token){
         list.add(token);
    }

    public void removeToken(String token){
        list.remove(token);
    }

    public boolean checkedToken(String token){
        return list.contains(token);
    }
}
