package com.kd27.feng.service.impl;
 import com.kd27.feng.dao.RoleDao;
 import com.kd27.feng.dao.UserDao;
 import com.kd27.feng.entity.User;
 import org.springframework.stereotype.Service;
 import com.kd27.feng.service.UserService;
 import java.util.Arrays;
 import java.util.List;








@Service
public class UserServiceImpl implements UserService {

    private final RoleDao roleDao;
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }



    @Override
    public User loginVerify(String username, String password) {
        if (userDao.login(username, password)!=null){
            return userDao.login(username, password);
        }else {
            User tmp=userDao.selectUserByName(username);
            if (tmp!=null){
                tmp.setPassword(null);
                return tmp;
            }
        }
        return null;
    }

    @Override
    public User selectUser(Integer user_id) {
        return userDao.selectUser(user_id);
    }


    @Override
    public User selectUserByName(String username) {
        return userDao.selectUserByName(username);
    }

    @Override
    public User selectUserById(int userId) {
        return userDao.selectUser(userId);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void registerUser(User user) {
        user.setUsername(user.getUsername().trim());
        user.setPassword(user.getPassword().trim());
        userDao.register(user);
        roleDao.addRole("COMMON",user.getUserId());
    }

    @Override
    public void addRole(String roleName, Integer userId) {
        roleDao.addRole(roleName, userId);
    }
}
