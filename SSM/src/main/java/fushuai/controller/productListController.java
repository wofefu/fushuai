package fushuai.controller;

import fushuai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class productListController {
    private final UserService userService;

    public productListController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/productList")
    public String productList(){
        return "productList";
    }
}
