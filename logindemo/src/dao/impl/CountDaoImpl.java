package dao.impl;

import dao.CountDao;
import entity.MiniBlog;
import entity.Praise;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.MyDBUtil;
import vo.Count;

import java.math.BigDecimal;
import java.sql.SQLException;

public class CountDaoImpl implements CountDao {
    private QueryRunner queryRunner = new QueryRunner(MyDBUtil.ds);

    @Override
    public Count count(int userId) {
        String sql1 = "select count(*) as count" +
                " from mini_blog where user_id = ?;";
        String sql2 = "select count(*) as count" +
                " from praise where user_id = ?;";
        String sql3 = "select sum(praiseNum) as sum" +
                " from mini_blog" +
                " where user_id = ?;";
        String sql4 = "select" +
                "  id from mini_blog" +
                " where user_id = ?" +
                " order by praiseNum desc, create_time desc" +  //按照赞数排序，赞数相同则按时间再排序
                " limit 0, 1;";
        try {
            //Long blog=queryRunner.query(sql1,new ScalarHandler<>("count"),userId);
            //Long likes=queryRunner.query(sql2,new ScalarHandler<>("count"),userId);
            //BigDecimal sum=queryRunner.query(sql3,new ScalarHandler<>("sum"),userId);  获取单列可以这么写
            MiniBlog num1 = queryRunner.query(sql1, new BeanHandler<>(MiniBlog.class), userId);
            Praise num2 = queryRunner.query(sql2, new BeanHandler<>(Praise.class), userId);
            MiniBlog num3 = queryRunner.query(sql3, new BeanHandler<>(MiniBlog.class), userId);
            MiniBlog num4 = queryRunner.query(sql4, new BeanHandler<>(MiniBlog.class), userId);
            Count count = new Count();
            count.setNum1(num1.getCount());
            count.setNum2(num2.getCount());
            count.setNum3(num3.getSum());
            count.setNum4(num4.getId());
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
