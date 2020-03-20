package com.example.demo.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class DataConverter implements Converter<String, Date> {
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy年MM月dd日");
    @Override
    public Date convert(String s) {
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            try {
                return simpleDateFormat1.parse(s);
            } catch (ParseException ex) {
                throw new  RuntimeException("日期格式错误");
            }
        }
    }
}
