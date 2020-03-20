package com.example.demo.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.demo.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByUsernameAndPassword(@Param("username")String username,@Param("password")String password);

    User findByUsername(@Param("username")String username);




}