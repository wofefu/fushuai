package service;

import entity.User;

public interface UserService {
    //根据用户名和密码登陆
    User findUser(String name, String pwd);
    int addUser(String name, String pwd);
    //修改用户
    int UpdateUser(User user);
    //上传图片
    int Picture(String icon,int id);
}
