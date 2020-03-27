package fushuai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TuiliuController {
    @GetMapping("tuiliu")
    public String tuiliu(){
        return "tuiliu";
    }
}
