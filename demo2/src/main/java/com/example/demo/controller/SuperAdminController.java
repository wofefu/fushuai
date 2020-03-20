package com.example.demo.controller;

import com.example.demo.annotation.HasRole;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SuperAdminController {

    private final UserService userService;

    public SuperAdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    @HasRole("SUPER_ADMIN")
    public ModelAndView addNew(String phone, String password) {
        //业务 添加账号

        userService.addManger(phone, password);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addManagerSuccess");
        mv.addObject("user", new User(phone, password));
        return mv;
    }




}
