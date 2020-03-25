package dao.impl;

import dao.MiniBlogDao;
import entity.MiniBlog;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.MyDBUtil;
import vo.VoDiscuss;
import vo.VominiBlog;

import java.sql.SQLException;
import java.util.List;

public class MinilogDaoPmpl implements MiniBlogDao {
    private QueryRunner queryRunner = new QueryRunner(MyDBUtil.ds);

    @Override
    public List<VominiBlog> select(int PageSize, int countNum, Integer uId) {

        String sql = "select" +
                "  mb.create_time as createtime," +
                "  mb.content     as content," +
                "  mb.user_id     as userid," +
                "  u.nickName     as nickName," +
                "  u.icon         as icon ,mb.praiseNum as praiseNum,p.user_id as uId,mb.id as id from user u inner join mini_blog mb on u.id = mb.user_id left join (select * from praise where user_id=?)  p on p.blog_id=mb.id where mb.deleted=0 order by mb.create_time desc limit ?, ?";
        Object[] params = {uId, countNum, PageSize};
        try {
            return queryRunner.query(sql, new BeanListHandler<>(VominiBlog.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int intsetContnet(MiniBlog miniBlog) {
        String sql = "insert into mini_blog(content, create_time, user_id) VALUES (?,now(),?)";
        Object[] params = {miniBlog.getContent(), miniBlog.getUserId()};
        try {
            queryRunner.execute(sql, params);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(int id, int praiseNum) {
        String sql = "update mini_blog set praiseNum=? where id=?";
        Object[] params = {praiseNum, id};
        try {
            queryRunner.execute(sql, params);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<VominiBlog> selectMyBlog(Integer minBlogId, Integer uId) {

        try {
            if (minBlogId == null) {
                    String sql = "select" +
                        " mb.id as id,mb.content as content,mb.create_time as createtime,mb.praiseNum as praiseNum , u.icon   as icon,u.nickName as nickName from mini_blog mb inner join" +
                        " user u on mb.user_id = u.id  where user_id = ? and" +
                        " mb.deleted=0 order by praiseNum desc, create_time desc" +  //按照赞数排序，赞数相同则按时间再排序
                        " limit 5;";
                return queryRunner.query(sql, new BeanListHandler<>(VominiBlog.class), uId);
            }else {
                String sql = "select" +
                        " mb.id as id,mb.content as content,mb.create_time as createtime,mb.praiseNum as praiseNum , u.icon   as icon,u.nickName as nickName from mini_blog mb inner join" +
                        " user u on mb.user_id = u.id  where user_id = ? and" +
                        " mb.deleted=0 and mb.id< ?  order by praiseNum desc, create_time desc" +  //按照赞数排序，赞数相同则按时间再排序
                        " limit 5;";
                return queryRunner.query(sql, new BeanListHandler<>(VominiBlog.class), uId,minBlogId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void reuandelete(int userId, int blogId) {
        String sql = "update mini_blog set deleted=1 where user_id=? and id=?";
        try {
            queryRunner.execute(sql, userId, blogId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<VoDiscuss> selectDis( int blogId) {
        String sql="select" +
                "  u.nickName as nickName," +
                "  u.icon     as icon," +
                "  d.content  as content" +
                " from discuss d inner join user u on d.user_id = u.id" +
                " where  d.blog_id = ?;";
        try {
            return queryRunner.query(sql,new BeanListHandler<>(VoDiscuss.class),blogId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}