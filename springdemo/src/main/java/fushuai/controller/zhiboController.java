package fushuai.controller;

import fushuai.entity.Anchor;
import fushuai.entity.User;
import fushuai.service.ZhiBoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class zhiboController {
    private final ZhiBoService zhiBoService;

    public zhiboController(ZhiBoService zhiBoService) {
        this.zhiBoService = zhiBoService;
    }

    @GetMapping("/all/zhibo")
    public String zhibo() {
        return "zhibo";
    }

    @GetMapping("/all/zhiboshezhi")
    public String zhiboshezhi() {
        return "zhiboshezhi";
    }

    @PostMapping("/all/zhiboshezhi")
    public String zhibosheZhi(Anchor anchor, @RequestPart(value = "file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        User user= (User) request.getSession().getAttribute("user");
        InputStream inputStream = multipartFile.getInputStream();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        String partPath = "resources/user_resources/img/" +user.getId()+"/" + simpleDateFormat.format(new Date())+"/"+multipartFile.getOriginalFilename();
        anchor.setIcon(partPath);
        anchor.setuId(user.getId());
        String realPath = request.getServletContext().getRealPath(partPath);
        zhiBoService.keepFileByInputStream(inputStream, partPath, realPath, anchor);
        return "redirect:/tuiliu";
    }
}
