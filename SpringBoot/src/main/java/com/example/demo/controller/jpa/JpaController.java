package com.example.demo.controller.jpa;
import com.example.demo.dao.jpa.DataJpaDao;
import com.example.demo.entity.jpa.DataJpa;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class JpaController {
    private final DataJpaDao dataJpaDao;

    public JpaController(DataJpaDao dataJpaDao) {
        this.dataJpaDao = dataJpaDao;
    }

    @PostMapping("/login")
    public DataJpa login(String username, String password) {
        return dataJpaDao.findAllByUsernameAndPassword(username, password);
    }
    @GetMapping("/count")
    public int count(String username){
        return dataJpaDao.countAllByUsernameLike("%"+username+"%");
    }
    //查询所有用户并分页
    @GetMapping("findall")
    public Page<DataJpa> allBypage(Integer pagesize,Integer pageindex){
        return dataJpaDao.findAll(PageRequest.of(pageindex-1,pagesize));
    }
    //模糊查询并分页
    @GetMapping("/like")
    public List<DataJpa> like(String name,Integer pagesize,Integer pageindex){
        return dataJpaDao.findAllByUsernameLike(name,PageRequest.of(pageindex-1,pagesize));
    }
    //返回vo数据 用Jsonview处理
    @GetMapping("/base")
    @JsonView({DataJpa.Base.class})
    public DataJpa base(){
        return dataJpaDao.findById(1L).orElse(null);
    }
}
