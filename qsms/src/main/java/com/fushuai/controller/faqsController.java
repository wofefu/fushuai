package com.fushuai.controller;

import com.fushuai.entity.Classes;
import com.fushuai.entity.Faqs;
import com.fushuai.service.ClassesService;
import com.fushuai.service.FaqsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class faqsController {
    private final FaqsService faqsService;
    private final ClassesService classesService;

    public faqsController(FaqsService faqsService, ClassesService classesService) {
        this.faqsService = faqsService;
        this.classesService = classesService;
    }

    /**
     * 获取所有的问题
     * @return
     */
    @GetMapping("getquestions")
    public List<Faqs> getquestions(){
          return faqsService.getall();
      }

    /**
     * 模糊查询
     */
    @GetMapping("/selectliketitle/{title}")
    public List<Faqs> selectliketitle(@PathVariable String title){
        return faqsService.getalllike(title);
    }
    /**
     * 获取都一个问题
     */
    @GetMapping("getOnequestion/{uid}")
    public Faqs getOnequestion(@PathVariable Integer uid){
        Long id= Long.valueOf(uid);
        return faqsService.getone(id);
    }
    /**
     * 获取所有classes
     */
    @GetMapping("allclass")
    public List<Classes> allclass(){
        return classesService.findall();
    }
    /**
     * 添加常见问题
     */
    @PostMapping("savequestion")
    public int savequestion(@RequestBody Faqs faqs){
        return faqsService.insert(faqs);
    }
}
