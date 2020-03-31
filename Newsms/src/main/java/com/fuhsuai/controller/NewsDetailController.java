package com.fuhsuai.controller;

import com.fuhsuai.entity.NewsCategory;
import com.fuhsuai.entity.NewsDetail;
import com.fuhsuai.service.NewsCategoryService;
import com.fuhsuai.service.NewsDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsDetailController {
    private final NewsCategoryService newsCategoryService;
    private final NewsDetailService newsDetailService;

    public NewsDetailController(NewsCategoryService newsCategoryService, NewsDetailService newsDetailService) {
        this.newsCategoryService = newsCategoryService;
        this.newsDetailService = newsDetailService;
    }
    //并实现查询所有新闻、查询所有新闻分类、根据 新闻分类和新闻标题查询新闻、根据新闻编号查询新闻详细信息和修改新闻功能。

    /**
     * 实现查询所有新闻
     */
    @GetMapping("findDetailall")
    public List<NewsDetail> findByAll() {
        return newsDetailService.findByAll();
    }

    /**
     * 查询所有新闻分类、
     */
    @GetMapping("findCateall")
    public List<NewsCategory> findByAll1() {
        return newsCategoryService.findByAll();
    }

    /**
     * 根据 新闻分类和新闻标题查询新闻
     */
    @GetMapping("selectbytitleandname/{title}/{classId}")
    public List<NewsDetail> findByNameAndTitle(@PathVariable String title, @PathVariable String classId) {
        return newsDetailService.findByNameAndTitle(Long.valueOf(classId), title);
    }

    /**
     * 根据新闻编号查询新闻详细信息
     */
    @GetMapping("findbycid/{cid}")
    public NewsDetail findCategoryid(@PathVariable String cid) {
        String cid1 = cid.trim();
        return newsDetailService.findCategoryid(Long.valueOf(cid1));

    }

    /**
     * 根据新闻编号修改新闻接口
     */
    @PostMapping("updatebycid")
    public int updateByCategoryid(@RequestBody NewsDetail newsDetail) {
        System.out.println(newsDetail+"asdfasdfads");
        return newsDetailService.updateByCategoryid(newsDetail);
    }
}
