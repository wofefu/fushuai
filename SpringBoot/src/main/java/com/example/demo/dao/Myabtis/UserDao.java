package com.example.demo.dao.Myabtis;

import com.example.demo.dto.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface UserDao {
    User findBynameAndpassword(@Param("username") String username, @Param("password") String password);
}
