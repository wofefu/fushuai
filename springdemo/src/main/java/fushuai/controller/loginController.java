package fushuai.controller;
import fushuai.dto.Lesson;
import fushuai.entity.User;
import fushuai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class loginController {
    private final UserService userService;

    public loginController(UserService userService) {
        this.userService = userService;
    }

    //@GetMapping("/index")
    //public ModelAndView index(){
    //    ModelAndView modelAndView=new ModelAndView();
    //  User user= userService.login("admin","admin");
    //   modelAndView.setViewName("index");
    //   modelAndView.addObject("u",user);
    //    return modelAndView;
    //}

    @GetMapping("/public/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/public/login")
    //@ResponseBody
    public String login(User user, HttpServletRequest request) {
        System.out.println("用户进来" + user);
        User user1 = userService.login(user.getUsername(), user.getPassword());
        System.out.println("查出用户" + user1);
        //ModelAndView modelAndView=new ModelAndView();
        //System.out.println(user1);
        //modelAndView.setViewName("douyu");
        //modelAndView.addObject(user1);
        HttpSession session = request.getSession();
        session.setAttribute("user", user1);
        return "redirect:/all/douyu";
        //return JSON.toJSONString(user1);
        //JSON.parse(result);  前端解析一下
    }

    @PostMapping("/lesson")
    @ResponseBody
    public Lesson lesson() {
        Lesson lesson = new Lesson();
        lesson.setDate(new Date());
        lesson.setUsername("小明");
        return lesson;
    }
}
