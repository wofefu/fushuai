package com.fushuai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RouteController {
     @GetMapping("/detail/{id}")
    public String add(@PathVariable Integer id, HttpServletRequest request){
         request.setAttribute("id",id);
         return "detail";
     }
    @GetMapping("/question")
    public String question(){
        return "question";
    }
    @GetMapping("/add")
    public String add(){
        return "add";
    }
}
