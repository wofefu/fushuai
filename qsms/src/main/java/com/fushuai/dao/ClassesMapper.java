package com.fushuai.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.fushuai.entity.Classes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassesMapper {
    int insertSelective(Classes record);

    int updateByPrimaryKeySelective(Classes record);

    List<Classes> findall();


}