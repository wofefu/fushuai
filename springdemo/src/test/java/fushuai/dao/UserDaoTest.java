package fushuai.dao;

import fushuai.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void login() {
     User user=userDao.login("admin","admin");
     System.out.println(user);
    }

    @Test
    public void selectUser() {
    }

    @Test
    public void register() {
    }

    @Test
    public void insertRole() {
    }
}