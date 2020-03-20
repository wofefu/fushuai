package service.impl;

import annotation.Important;
import annotation.Need;
import annotation.ReqPath;
import dao.TestDao;
import service.TestService;

@Important
public class TestServiceImpl implements TestService {

    @Need
    private TestDao testDao;

    public TestServiceImpl() {

    }


    public String serviceTest() {
        System.out.println("进入到Service实现类的serviceTest方法");
        return testDao.test();
    }

    public static void main(String[] args) {

    }
}
