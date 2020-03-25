package service.impl;

import dao.PraiseDao;
import dao.impl.PraiseDaoImpl;
import entity.Praise;
import service.PraiseService;

public class PraiseServiceImpl implements PraiseService {
    private PraiseDao praiseDao=new PraiseDaoImpl();

    @Override
    public int update(int blogId, int userId) {
         praiseDao.updatePraise(blogId,userId);
         return 1;
    }
}
