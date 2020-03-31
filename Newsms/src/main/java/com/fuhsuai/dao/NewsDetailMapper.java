package com.fuhsuai.dao;

import com.fuhsuai.entity.NewsDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsDetailMapper {
    /**
     * 查询所有新闻接口、
     *
     * @return
     */
    List<NewsDetail> findByAll();

    /**
     * 根据新闻分类和新闻 标题查询新闻接口
     */
    List<NewsDetail> findByNameAndTitle(@Param("classId") Long classId, @Param("title") String title);

    /**
     * 根据新闻编号查询新闻详细信息接口
     */
   NewsDetail findCategoryid(@Param("categoryid") Long categoryid);

    /**
     * 根据新闻编号修改新闻接口
     */
    int updateByCategoryid(@Param("updated")NewsDetail updated);
}