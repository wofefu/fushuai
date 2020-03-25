package service.impl;

import dao.MiniBlogDao;
import dao.impl.MinilogDaoPmpl;
import entity.MiniBlog;
import service.VominiBlogService;
import vo.VoDiscuss;
import vo.VominiBlog;


import java.util.List;

public class VominiBlogServiceImpl implements VominiBlogService {
    private MiniBlogDao miniBlogDao=new MinilogDaoPmpl();
    @Override
    public List<VominiBlog> select(int pageSize, int page,Integer uId) {
        int countNum=(page-1)*pageSize;
        return   miniBlogDao.select(pageSize,countNum,uId);
    }

    @Override
    public int insertContent(MiniBlog miniBlog) {
        return miniBlogDao.intsetContnet(miniBlog);
    }

    @Override
    public int update(int id, int praiseNum) {
        return miniBlogDao.update(id,praiseNum);
    }

    @Override
    public List<VominiBlog> selectMyBlog(Integer minBlogId, Integer uId) {
        return   miniBlogDao.selectMyBlog(minBlogId,uId);
    }

    @Override
    public void ruandelete(int userId, int blogId) {
          miniBlogDao.reuandelete(userId,blogId);
    }

    @Override
    public List<VoDiscuss> selectDis( int blogId) {
        return miniBlogDao.selectDis(blogId);
    }
}
