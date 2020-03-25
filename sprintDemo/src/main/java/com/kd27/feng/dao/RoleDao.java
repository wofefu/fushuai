package com.kd27.feng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleDao {

    void addRole(@Param("roleName") String roleName,@Param("userId") Integer userId);
}
