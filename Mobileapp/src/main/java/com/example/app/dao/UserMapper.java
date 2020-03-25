package com.example.app.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.app.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findByPhoneAndPassword(@Param("phone")String phone,@Param("password")String password);


}