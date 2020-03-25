package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User findUser(String name, String pwd) {

        User user = userDao.find(name, pwd);
        System.out.println(user.getGender());
        return user;
    }

    @Override
    public int addUser(String name, String pwd) {
        return userDao.creatUser(name,pwd);
    }

    @Override
    public int UpdateUser(User user) {
       return userDao.updateUser(user);
    }

    @Override
    public int Picture(String icon, int id) {
        return userDao.shangchuanPicture(icon,id);
    }


    //@Override
    //public boolean addUser(String name, String pwd) {
    //    int num=userDao.insert(name,pwd);
    //    if (num!=-1){
    //        return true;
    //    }else {
    //        return false;
    //    }
    //}
}
