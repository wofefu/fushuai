package dao;

import entity.User;

public interface UserDao {
    User find(String name,String pwd);
    int creatUser(String name,String pwd);
    int updateUser(User user);
    int shangchuanPicture(String icon,int id);
}
