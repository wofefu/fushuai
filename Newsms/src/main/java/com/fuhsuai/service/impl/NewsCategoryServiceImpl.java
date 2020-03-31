package com.fuhsuai.service.impl;

import com.fuhsuai.entity.NewsCategory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.fuhsuai.dao.NewsCategoryMapper;
import com.fuhsuai.service.NewsCategoryService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, rollbackFor = Throwable.class, timeout = 5000)
public class NewsCategoryServiceImpl implements NewsCategoryService{

    @Resource
    private NewsCategoryMapper newsCategoryMapper;

    public List<NewsCategory> findByAll() {
        return newsCategoryMapper.findByAll();
    }
}
