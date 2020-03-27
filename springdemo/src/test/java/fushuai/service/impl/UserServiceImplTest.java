package fushuai.service.impl;

import fushuai.dao.UserDao;
import fushuai.entity.User;
import fushuai.service.UserService;
import org.junit.Assert;
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
    private UserService userDao;

    @Test
    @Transactional
    public void login() {
      User user= userDao.login("admin","admin");
        Assert.assertNotNull(user);
    }

    @Test
    public void register() {
    }
}