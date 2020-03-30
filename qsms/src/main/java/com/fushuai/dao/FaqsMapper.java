package com.fushuai.dao;

import com.fushuai.entity.Faqs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FaqsMapper {
    int insertSelective(Faqs record);

    int updateByPrimaryKeySelective(Faqs record);

    List<Faqs> getall();

    Faqs getone(Long id);

    List<Faqs> getalllike(@Param("title") String title);

    int insert(@Param("faqs") Faqs faqs);
}