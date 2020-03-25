package fushuai.controller;


import fushuai.entity.Member;
import fushuai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     *接收登录请求
     * @return  跳到登录页
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     *用户登录提交表单后 页面跳转情况
     * @param tel  手机号
     * @param password   密码
     * @param request  创建session并将用户放入session中
     * @return  如果用户不为空 ，角色是SUPERADMIN则 跳到后台管理  不是的话为普通用户跳回首页
     * 否则登录不成功，仍返回登录页
     */
    @PostMapping("/login")
    public String loginPage(String tel, String password, HttpServletRequest request) {
        Member member = userService.selectByTelAndPassword(tel, password);
        System.out.println(member+"----------------");
        request.getSession().setAttribute("user", member);
        if (member != null) {
            if (member.getRoles().contains("SUPERADMIN")) {
                return "redirect:/userlist";
            } else {
                return "index";
            }
        } else {
            System.out.println("登录失败");
            return "login";
        }
    }

    /**
     * 用户注销
     * @param request 获取session中的用户，并remove
     * @return  返回首页
     */
    @GetMapping("/logout")
     public  String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "index";
     }

}
