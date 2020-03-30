package com.fushuai.service;

import com.fushuai.entity.Classes;

import java.util.List;

public interface ClassesService{


    int insertSelective(Classes record);

    int updateByPrimaryKeySelective(Classes record);

    List<Classes> findall();
}
