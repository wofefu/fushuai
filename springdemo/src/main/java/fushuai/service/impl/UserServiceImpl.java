package fushuai.service.impl;

import fushuai.dao.UserDao;
import fushuai.entity.User;
import fushuai.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String username, String password) {
        //SqlSession session= MyDBUtil.getSession();
        //UserDao userDao=session.getMapper(UserDao.class);
        return userDao.login(username,password);
    }
    public void register(String username, String password){
        //SqlSession session=MyDBUtil.getSession();
        //UserDao userDao=session.getMapper(UserDao.class);
        User user=new User();
        user.setPassword(password);
        user.setUsername(username);
        //try {
            userDao.register(user);
            userDao.insertRole(user.getId());
            //session.commit();
        //}catch(Exception e){
        //    session.rollback();
        //}
        //session.close();
    }
}
