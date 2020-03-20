package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
public class DateController {
    @GetMapping("/date")
    public Date date(Date date){
        return date;
    }

}
