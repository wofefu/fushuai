package fushuai.controller;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
import fushuai.dto.Person;
import fushuai.entity.User;
import fushuai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {
    //@Autowired
    //    //private UserService userService;
    //    //@GetMapping("/index")
    //    //public  String index(HttpServletRequest requst){
    //    //    requst.setAttribute("name","牛biaa啊");
    //    //    List<Integer> list= Arrays.asList(1,2,3);
    //    //    requst.setAttribute("list",list);
    //    //    return "index";
    //    //}
    //private final UserService userService;
    //
    //public TestController(UserService userService) {
    //    this.userService = userService;
    //}
    //
    //@GetMapping("/index")
    //public ModelAndView index(HttpServletRequest requst){
    //    ModelAndView mv=new ModelAndView();
    //    mv.setViewName("index");
    //    mv.addObject("name","你把");
    //    return mv;
    //}
    //@GetMapping(value = "home",produces = "application/json:charset=UTF-8")
    //@ResponseBody
    //public  String  home(){
    //    String a="asdfasd";
    //    List<Integer> list=Arrays.asList(1,2,3);
    //    JSONArray.toJSONString(list);
    //    return JSON.toJSONString(a);
    ////}
    //@GetMapping("/index")
    //public String index(){
    //   return "index";
    //}

    //@PostMapping(value = "/login",produces = "application/json:charset=UTF-8")
    //@ResponseBody
    //public String login(User user){
    //    System.out.println(user);
    //    return JSON.toJSONString(user);
    //}
    @GetMapping("index")
    @CrossOrigin
    public String index(){
        return "index";
    }
    @PostMapping("/test")
    @ResponseBody
    public Person test(@RequestBody Person person) {
          return person;
    }
    @PostMapping("/test1")
    @ResponseBody
    public Person test1(Person person) {
        return person;
    }
}
