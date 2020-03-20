package com.example.demo.dao.jpa;

import com.example.demo.entity.jpa.DataJpa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataJpaDao extends JpaRepository<DataJpa,Long> {

    DataJpa findAllByUsernameAndPassword(String username, String password);
    //模糊查询用户总数
    int countAllByUsernameLike(String username);
    //相同粉丝数 按id从大到小排列
    List<DataJpa> findAllByUsernameOrderByIdDesc(String username);

    //分页
    //mybatis分页解决，也不是自己写limit 是推荐你使用github上的pageHelper依赖
    //jpa不需要关注这个问题
    //查询所有用户信息并分页
    List<DataJpa> findAll();
    //查询用户名含有a的用户并分页
    List<DataJpa> findAllByUsernameLike(String username, Pageable pageable);

    //条件查询、聚合排序、分页、去重、都可以使用它简单的完成
}
