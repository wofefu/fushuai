package com.example.demo.controller;

import com.example.demo.dto.MyRespose;
import com.example.demo.dto.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Api("与测试相关")
public class TestController {
    //注解上写配置文件上对应的key
    @Value("${welcome}")
    private  String welcome;

    @Value("${fuza.welcome}")
    private  String welcomea;
    @Value("${fuza.img}")
    private  String img;
    private final Fuza fuza;

    public TestController(Fuza fuza) {
        this.fuza = fuza;
    }

    @GetMapping("index")
    public String index(){
        return welcome;
    }
    @GetMapping("/fuza")
    public String fuza(){
        return fuza.getImg()+fuza.getWelcome();
    }

  //知识点3：参数处理  restful Api
    //参数形式  PathValriable   路径上的参数
    //以前  /info?id=2
    @GetMapping("/p/{id}")
    public int info(@PathVariable("id") int id){
        return id;
    }
     //第二种方式  常见的@RequestParam
     @RequestMapping("/name")  //post get 请求都可以
    public String str(@RequestParam String name){
        return name;
    }

    //第三种方式 json数据接收
    @PostMapping("/user")
    public User user(@RequestBody User user){
        return user;
    }
    @GetMapping("/test")
    //@ResponseBody
    public String test() {
        return "success";
    }

    @GetMapping("/message")
    @ApiOperation("返回类似api接口的数据")
    //@ResponseBody
    public MyRespose<User> message() {
        User user = new User();
        user.setAge(18);
        user.setDate(new Date());
        user.setName("付帅");
        MyRespose<User> myRespose = new MyRespose<User>();
        myRespose.setCode(1);
        myRespose.setMessage("请求成功");
        myRespose.setResult(user);
        return myRespose;
    }
}
