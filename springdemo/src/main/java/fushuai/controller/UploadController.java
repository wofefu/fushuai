package fushuai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
@Controller
public class UploadController {
    //@PostMapping("upload")
    //public void upload(String name , HttpServletRequest req, @RequestParam("file")MultipartFile file){
    //    try {
    //        System.out.println(name);
    //        System.out.println(file.getName());
    //        System.out.println(file.getOriginalFilename());
    //        Part part= req.getPart("icons");
    //        System.out.println(part.getSize());
    //        System.out.println(part.getSubmittedFileName());
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    } catch (ServletException e) {
    //        e.printStackTrace();
    //    }
    //}
    @GetMapping("/Upload")
    public String uploada(){
        return "Upload";
    }
    @PostMapping("/Upload")
    public void upload(String name,MultipartFile[] files){
        System.out.println(name);
        for (MultipartFile file : files) {
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getName());
            System.out.println(file.getSize());
        }
    }
}
