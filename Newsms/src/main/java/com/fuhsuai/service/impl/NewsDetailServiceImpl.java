package com.fuhsuai.service.impl;

import com.fuhsuai.entity.NewsDetail;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.fuhsuai.dao.NewsDetailMapper;
import com.fuhsuai.service.NewsDetailService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, rollbackFor = Throwable.class, timeout = 5000)
public class NewsDetailServiceImpl implements NewsDetailService{

    @Resource
    private NewsDetailMapper newsDetailMapper;

    public List<NewsDetail> findByAll() {
        return newsDetailMapper.findByAll();
    }

    public List<NewsDetail> findByNameAndTitle(Long cateid, String title) {
      String  title1="%"+title+"%";
        return newsDetailMapper.findByNameAndTitle(cateid, title1);
    }

    public NewsDetail findCategoryid(Long categoryid) {
        System.out.println("进来了吗");
        return newsDetailMapper.findCategoryid(categoryid);
    }

    public int updateByCategoryid(NewsDetail updated) {
        return newsDetailMapper.updateByCategoryid(updated);
    }
}
