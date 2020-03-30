package com.fushuai.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.fushuai.entity.Faqs;
import com.fushuai.dao.FaqsMapper;
import com.fushuai.service.FaqsService;

import java.util.List;

@Service
public class FaqsServiceImpl implements FaqsService{

    @Resource
    private FaqsMapper faqsMapper;

    @Override
    public int insertSelective(Faqs record) {
        return faqsMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Faqs record) {
        return faqsMapper.updateByPrimaryKeySelective(record);
    }

    public List<Faqs> getall() {
        return faqsMapper.getall();
    }

    public Faqs getone(Long id) {
        return faqsMapper.getone(id);
    }

    public List<Faqs> getalllike(String title) {
        String tt='%'+title+'%';
        return faqsMapper.getalllike(tt);
    }

    public int insert(Faqs faqs) {
        return faqsMapper.insert(faqs);
    }
}
