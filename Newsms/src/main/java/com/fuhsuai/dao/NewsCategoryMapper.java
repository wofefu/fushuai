package com.fuhsuai.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.fuhsuai.entity.NewsCategory;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsCategoryMapper {
    /**
     * 查询所有新闻分类接口、
     * @return
     */
    List<NewsCategory> findByAll();


}