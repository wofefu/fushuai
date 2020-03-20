package com.cdchen.auth.controller;

import com.cdchen.auth.auth.annotation.AuthId;
import com.cdchen.auth.auth.annotation.HasAuth;
import com.cdchen.auth.entity.Role;
import com.cdchen.auth.entity.Secret;
import com.cdchen.auth.entity.User;
import com.cdchen.auth.service.RoleService;
import com.cdchen.auth.service.SecretService;
import com.cdchen.auth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private final SecretService secretService;

    private final UserService userService;
    private final RoleService roleService;

    public UserController(SecretService secretService, UserService userService, RoleService roleService) {
        this.secretService = secretService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    @HasAuth
    public String index(Model model) {

        List<Role> list = roleService.allRoles();
        model.addAttribute("roles", list);
        return "index";
    }

    @PostMapping("/login")
    public String doLogin(String username, String password, HttpSession session, Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:index";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView register(String username, String password) {
        userService.register(username, password);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        mv.addObject("msg", "注册成功请登录");
        return mv;
    }

    @PostMapping("/buy")
    @HasAuth
    public String buy(Long[] roleIds, HttpSession session) {
        if(roleIds==null){
            roleIds=new Long[]{};
        }
        User u = (User) session.getAttribute("user");
        u = userService.buyRole(u.getId(), roleIds);
        session.setAttribute("user", u);

        return "redirect:index";
    }
    @GetMapping("/personal")
    //HasAuth注解 虽然能遍历反射的参数 和真实的参数
    //但是 如果你天马行空 对这种表示身份的参数命名也是随心所欲
    //在遍历时 我就不知道 到底哪一个参数 才是要拿来进行私人验证的参数
    //那就再为HasAuth注解 额外定义一个属性 要求开发者 通过属性的方式 告诉我
    //我究竟应该拿你的哪一个名字槽点满满的参数来检验私人身份
    @HasAuth(id = "#userId")
    public String personal( Long userId, Model model){
        List<Secret> list = secretService.byUserId(userId);
        model.addAttribute("secret",list);
        return "personal";
    }

//    RBAC role based access control

//    @PostMapping("/secret/delete")
//    @HasAuth(id = "#userId")
//    public String delete(Long userId,Long secretId){
//        //要么就首先判断 帖子的用户id是不是你 还是需要先select
//        //delete from secret where id = 1
//        //and userId = ?
//
//    }

}
