package fushuai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    /**
     * 处理首页请求
     * @return  返回首页
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
