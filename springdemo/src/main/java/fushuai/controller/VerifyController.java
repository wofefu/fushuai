package fushuai.controller;

import fushuai.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VerifyController {
    private final VerifyService verifyService;

    public VerifyController(VerifyService verifyService) {
        this.verifyService = verifyService;
    }
    @GetMapping("/verify")
    public String verify(){
       return "verify";
    }
    @PostMapping("/verify")
    public void  Verify(String name,String phone,String idcard){

          verifyService.verify(name,phone,idcard);
    }
}
