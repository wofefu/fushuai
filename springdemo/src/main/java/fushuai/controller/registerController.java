package fushuai.controller;

import fushuai.entity.User;
import fushuai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class registerController {
    private final UserService userService;

    public registerController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/public/register")
    public String register(){
        return "register";
    }
    @PostMapping("/public/register")
    public String toregister(User user){
        try {
            userService.register(user.getUsername(),user.getPassword());
            System.out.println("进来了");
            return "redirect:/public/login";
        }catch (Exception e){
            e.getMessage();
        }
         return "redirect:/public/register";
    }
}
