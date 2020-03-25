package dao.impl;

import dao.DiscussDao;
import org.apache.commons.dbutils.QueryRunner;
import utils.MyDBUtil;

import java.sql.SQLException;

public class DiscussDaoImpl implements DiscussDao {
    private QueryRunner queryRunner=new QueryRunner(MyDBUtil.ds);
    @Override
    public void insert(int blogId, int userId, String content) {
        //System.out.println(blogId+userId+content+"neiasdf");
        String sql="insert into discuss(content, createtime, user_id, blog_id) VALUES (?,now(),?,?)";
        try {
          int num=  queryRunner.execute(sql,content,userId,blogId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
