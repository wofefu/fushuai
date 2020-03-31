package com.fuhsuai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RouterController {
    @GetMapping("index")
    public String index(){
        return "index";
    }
    @GetMapping("modify/{id}")
    public String modify(@PathVariable String id, HttpServletRequest request){
        request.setAttribute("did",id);
        return "modify";
    }
}
