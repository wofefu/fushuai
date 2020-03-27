package fushuai.controller;


import com.alibaba.fastjson.JSONObject;
import fushuai.entity.Anchor;
import fushuai.entity.User;
import fushuai.service.KaiboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class KaiboController {
    private final KaiboService kaiboService;

    public KaiboController(KaiboService kaiboService) {
        this.kaiboService = kaiboService;
    }

    @GetMapping("/kaibo")
    public String kaibo() {
        return "kaibo";
    }

    @PostMapping("/kaibo")
    public String kaiBo(String name, String phone, String idcard, HttpServletRequest request, Anchor anchor) {
        JSONObject jsonObject = kaiboService.verify(name, phone, idcard);
        JSONObject res = (JSONObject) jsonObject.get("result");
        String s = res.getString("VerificationResult");
        if (s.equals("1")) {
            User user = (User) request.getSession().getAttribute("user");
            System.out.println(user + "_________________");
            anchor.setuId(user.getId());
            kaiboService.insert(anchor);
            return "redirect:/all/douyu";
        } else {
            return "error";
        }
    }
}
