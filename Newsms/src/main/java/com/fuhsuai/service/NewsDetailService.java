package com.fuhsuai.service;

import com.fuhsuai.entity.NewsDetail;

import java.util.List;

public interface NewsDetailService{


    List<NewsDetail> findByAll();

    List<NewsDetail> findByNameAndTitle(Long categoryid, String title);

    NewsDetail findCategoryid(Long categoryid);

    int updateByCategoryid(NewsDetail newsDetail);
}
