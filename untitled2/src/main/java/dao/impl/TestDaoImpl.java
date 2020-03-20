package dao.impl;

import annotation.Important;
import dao.TestDao;



@Important
public class TestDaoImpl implements TestDao {

    public TestDaoImpl() {
    }

    public String test() {
        System.out.println("进入到Dao实现类的test方法");
        return "success";
    }
}
