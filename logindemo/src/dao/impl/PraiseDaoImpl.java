package dao.impl;

import dao.PraiseDao;
import entity.Praise;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.MyDBUtil;

import java.sql.SQLException;

public class PraiseDaoImpl implements PraiseDao {
    private QueryRunner queryRunner = new QueryRunner(MyDBUtil.ds);

    @Override
    public void updatePraise(int blogId, int userId) {
        String sql = "select * from praise where blog_id=? and user_id=?";
        Object[] params1 = {blogId, userId};
        try {
            Praise praise = queryRunner.query(sql, new BeanHandler<>(Praise.class), params1);
            if (praise == null) {
                inserPraise(blogId, userId);
                String add = "update mini_blog set praiseNum=praiseNum+1 where id=?";
                queryRunner.execute(add, blogId);
            } else {
                deletePraise(blogId, userId);
                String add = "update mini_blog set praiseNum=praiseNum-1 where id=?";
                queryRunner.execute(add, blogId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int inserPraise(int blogId, int userId) {
        String sql = "insert into praise(user_id, blog_id) VALUES (?,?)";
        Object[] params = {userId, blogId};
        try {
            queryRunner.execute(sql, params);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -2;
        }
    }

    @Override
    public int deletePraise(int blogId, int userId) {
        String sql = "delete from praise where blog_id=? and user_id=?";
        Object[] params = {blogId, userId};
        try {
            queryRunner.execute(sql, params);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -3;
        }
    }
}
