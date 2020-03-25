package com.kd27.feng.service.impl;

import com.kd27.feng.dao.UserDao;
import com.kd27.feng.entity.User;
import com.kd27.feng.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void allUser() {
    }

    @Test
    public void loginVerify() {
    }

    @Test
    public void selectUser() {
    }

    @Test
    public void selectUserByName() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    @Transactional
    public void registerUser() {
        User user=new User();
        user.setUsername("sexdtfghunjimkolp");
        user.setPassword("ytguhjiiiiii");
        userService.registerUser(user);
        System.out.println(user.getUserId());
    }
}