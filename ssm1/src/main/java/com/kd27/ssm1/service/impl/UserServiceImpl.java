package com.kd27.ssm1.service.impl;

import com.kd27.ssm1.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, timeout = 5000)
public class UserServiceImpl implements UserService {

    @Override
    public boolean isExists(String username) {
        return false;
    }
}
