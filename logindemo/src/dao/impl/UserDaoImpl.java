package dao.impl;

import dao.UserDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.MyDBUtil;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
   private QueryRunner queryRunner=new QueryRunner(MyDBUtil.ds);
    @Override
    public User find(String name, String pwd) {
        StringBuffer sql=new StringBuffer();
        sql.append("select * from user where name=? and pwd=?");
        Object[] params={name,pwd};
        try {
            return queryRunner.query(sql.toString(),new BeanHandler<>(User.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("asdf",e);
        }
    }

    @Override
    public int creatUser(String name, String pwd) {

        try {
            StringBuffer sql=new StringBuffer();
            sql.append("select * from user where name=? and pwd=?");
            Object[] params={name,pwd};
            User user= queryRunner.query(sql.toString(),new BeanHandler<>(User.class),params);
            if (user!=null){
                return -1;
            }else {
                StringBuffer sql1=new StringBuffer();
                sql1.append("insert into user(name, pwd) values (?,?)");
                Object[] params1={name,pwd};
                queryRunner.execute(sql1.toString(),params1);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -2;
        }
    }

    @Override
    public int updateUser(User user) {
        StringBuffer sql1=new StringBuffer();
        sql1.append("update user set nickName=?,gender=?,job=?,hometown=?,birthday=? where id=?");
        Object[] params1={user.getNickName(),user.getGender(),user.getJob(),user.getHometown(),user.getBirthday(),user.getId()};
        try {
            queryRunner.execute(sql1.toString(),params1);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int shangchuanPicture(String icon, int id) {
        StringBuffer sql1=new StringBuffer();
        sql1.append("update user set icon=?  where id=?");
        Object[] params1={icon,id};
        try {
            queryRunner.execute(sql1.toString(),params1);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
