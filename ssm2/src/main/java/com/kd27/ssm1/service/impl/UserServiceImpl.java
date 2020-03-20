package com.kd27.ssm1.service.impl;

import com.kd27.ssm1.dao.UserMapper;
import com.kd27.ssm1.entity.User;
import com.kd27.ssm1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, timeout = 5000)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean isExists(String username) {

        User user = userMapper.selectByUsername(username);

        return user != null ;
    }
}
