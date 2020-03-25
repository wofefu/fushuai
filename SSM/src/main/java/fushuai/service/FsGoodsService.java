package fushuai.service;

import fushuai.entity.FsGoods;

import java.util.List;

public interface FsGoodsService {


    int deleteByPrimaryKey(Integer id);

    int insert(FsGoods record);

    int insertSelective(FsGoods record);

    FsGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsGoods record);

    int updateByPrimaryKey(FsGoods record);

    List<FsGoods> findByAll(FsGoods fsGoods);
}

