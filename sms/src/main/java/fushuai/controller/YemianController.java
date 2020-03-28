package fushuai.controller;

import fushuai.dto.StudentDetail;
import fushuai.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class YemianController {
    private final StudentService studentService;

    public YemianController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/student")
    public String student(){
        return "student";
    }
    @GetMapping("/Student/{id}")
    public String studentClass(HttpServletRequest request, @PathVariable Integer id){
      request.setAttribute("id",id);
        return "person";
    }
}
