package com.kd27.ssm1.dao;

import com.kd27.ssm1.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectByUsername(@Param("username") String username);
}
