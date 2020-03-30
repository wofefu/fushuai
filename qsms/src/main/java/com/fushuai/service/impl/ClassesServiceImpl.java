package com.fushuai.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.fushuai.entity.Classes;
import com.fushuai.dao.ClassesMapper;
import com.fushuai.service.ClassesService;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService{

    @Resource
    private ClassesMapper classesMapper;

    @Override
    public int insertSelective(Classes record) {
        return classesMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Classes record) {
        return classesMapper.updateByPrimaryKeySelective(record);
    }

    public List<Classes> findall() {
        return classesMapper.findall();
    }
}
