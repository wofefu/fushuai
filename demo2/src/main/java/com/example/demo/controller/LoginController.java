package com.example.demo.controller;

import com.example.demo.annotation.HasRole;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(String username, String password, Model model, HttpSession session) {
        //具体业务 根据登录的用户 去不同的界面
        User u = userService.login(username, password);
        if (u == null) {
            model.addAttribute("msg", "用户名或密码不正确");
            return "login";
        } else {
            session.setAttribute("user", u);

            switch (u.getRole()) {
                case SUPER_ADMIN:
                    return "redirect:super_admin";
                case SHOP_MANAGER:
                    return "redirect:shop_admin/"+u.getId();
                case SALESMAN:
                    return "redirect:salesman";
                default:
                    return "error";

            }
        }

    }

    @GetMapping("/super_admin")
    @HasRole("SUPER_ADMIN")
    public String sa() {
        return "super_admin";
    }


    @GetMapping("/salesman")
    @HasRole({"SALESMAN", "SHOP_MANAGER"})
    public String sale() {
        return "salesman_shop";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
