package fushuai.controller;

import fushuai.entity.FsMember;
import fushuai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;



@Controller
public class PersonalController {
    private final UserService userService;

    public PersonalController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/personal")
    public String personal(){
        return "personal";
    }

    /**
     * 个人资料修改
     * @param fsMember  要修改的信息
     * @param request
     * @return  修改成功，或修改失败  返回个人中心页面
     */
    @PostMapping("/update")
    public String update(FsMember fsMember, HttpServletRequest request){
        System.out.println(fsMember+"---------------");
       int temp= userService.updateByPrimaryKey(fsMember);
        String message="修改失败";
       if (temp==1){
           message="修改成功";
       }
        request.setAttribute("msg",message);
        return "personal";
    }
}
