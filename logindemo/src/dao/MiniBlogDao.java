package dao;

import entity.Discuss;
import entity.MiniBlog;
import vo.VoDiscuss;
import vo.VominiBlog;

import java.util.List;

public interface MiniBlogDao {
      //分页查询

      /**
       * @param PageSize 当前页面显示的条数
       * @param countNum 从第几条开始
       * @return
       */
      List<VominiBlog>  select(int PageSize, int countNum,Integer uId);

      int intsetContnet(MiniBlog miniBlog);

      int update(int id,int praiseNum);

      /**
       *
       * @param minBlogId  当前页面的最后一条微博的id
       * @param uId  用户id
       * @return
       */
      List<VominiBlog>  selectMyBlog(Integer minBlogId,Integer uId);

      void reuandelete(int userId,int blogId);

      List<VoDiscuss> selectDis( int blogId);
}
