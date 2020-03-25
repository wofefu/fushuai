package fushuai.controller;


import com.alibaba.fastjson.JSONObject;
import fushuai.entity.Member;
import fushuai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class registerController {
    private final UserService userService;

    public registerController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 跳转到注册出错页
     *
     * @return 注册错误页
     */
    @GetMapping("/registererror")
    public String registererror() {
        return "registererror";
    }

    /**
     * 跳转到注册页
     *
     * @return 注册页
     */
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    /**
     * 用户注册提交表单后 页面跳转情况
     *
     * @param member   提交的表单信息
     * @param response 用户存在的话提示该注册用户已经存在
     * @return 实名注册，引用三方api，用户不为空，实名注册 返回jsonObject，如果信息符合事实，则注册成功，跳到登录页，否则 信息错误，跳转到注册失败页面
     */
    @PostMapping("/register")
    public String register(Member member, HttpServletResponse response) {
        Member member1 = userService.selectByTelAndPassword(member.getTel(), member.getPassWord());
        if (member1 == null) {
            JSONObject jsonObject = userService.verify(member);
            if (jsonObject != null) {
                JSONObject res = (JSONObject) jsonObject.get("result");
                String s = res.getString("VerificationResult");
                if (s.equals("1")) {
                    return "redirect:index";
                } else {
                    return "redirect:registererror";
                }
            }
        } else {
            try {
                response.getWriter().write("用户已存在");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
