package service.impl;

import dao.CountDao;
import dao.impl.CountDaoImpl;
import service.CountService;
import vo.Count;

public class CountServiceImpl implements CountService {
    private CountDao countDao=new CountDaoImpl();
    @Override
    public Count count(int userId) {
        return countDao.count(userId);
    }
}
