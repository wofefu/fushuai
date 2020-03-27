package fushuai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class douyuController {
    @GetMapping("/all/douyu")
    public String index() {
        return "douyu";
    }
}
