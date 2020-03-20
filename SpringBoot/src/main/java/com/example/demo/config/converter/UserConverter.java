package com.example.demo.config.converter;

import com.example.demo.entity.mybatis.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<String, User> {
    //洁省流量，传的字符串 1-fushuai
    @Override
    public User convert(String s) {
        String[] infos=s.split("-");
        User user=new User();
        user.setId(Integer.valueOf(infos[0])); //1
        user.setUsername(infos[1]); //fushaui
        return user;
    }
}
