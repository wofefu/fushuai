package service;

import entity.MiniBlog;
import vo.VoDiscuss;
import vo.VominiBlog;

import java.util.List;

public interface VominiBlogService {
    //查询数据

    /**
     *
     * @param pageSize  当前页面显示的对象VominiBlog条数
     * @param page      当前第几页
     * @return 返回VominiBlog的集合
     */
    List<VominiBlog> select(int pageSize, int page,Integer uId);

    int insertContent(MiniBlog miniBlog);

    int update(int id,int praiseNum);

    List<VominiBlog> selectMyBlog(Integer minBlogId,Integer uId);

    void ruandelete(int userId,int blogId);

    /**
     *遍历评论表
     *
     * @param blogId   那条微博评论条的id
     * @return
     */
    List<VoDiscuss> selectDis( int blogId);
}
