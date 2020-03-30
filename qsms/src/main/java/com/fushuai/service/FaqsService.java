package com.fushuai.service;

import com.fushuai.entity.Faqs;

import java.util.List;

public interface FaqsService{


    int insertSelective(Faqs record);

    int updateByPrimaryKeySelective(Faqs record);

    List<Faqs> getall();

    Faqs getone(Long id1);

    List<Faqs> getalllike(String title);

    int insert(Faqs faqs);
}
