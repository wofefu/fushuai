package service.impl;

import dao.DiscussDao;
import dao.impl.DiscussDaoImpl;
import service.DiscussService;

public class DiscussServiceImpl implements DiscussService {
    private DiscussDao discussDao=new DiscussDaoImpl();
    @Override
    public void insert(int blogId, int userId, String content) {
          discussDao.insert(blogId,userId,content);
    }
}
