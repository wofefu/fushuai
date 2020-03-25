package com.kd27.feng.dao;

import com.kd27.feng.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class UserDaoTest {
@Autowired
UserDao userDao;

@Test
    public void login() {
    User user =userDao.login("admin","admin");
    System.out.println(user);
    }

    @Test
    public void selectUser() {
    }

    @Test
    public void update() {
    }

    @Test
    public void register() {
    User user=new User();
    user.setPassword("4r5tyu");
    user.setUsername("tfgyhujk");
    userDao.register(user);
        System.out.println(user.getUserId());
    }
}