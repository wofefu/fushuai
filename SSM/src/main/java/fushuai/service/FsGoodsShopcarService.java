package fushuai.service;

import fushuai.dto.Shopcardto;
import fushuai.entity.FsGoodsShopcar;

import java.util.List;

public interface FsGoodsShopcarService{

    List<Shopcardto> findAll();
    int deleteByPrimaryKey(Integer id);

    int insert(FsGoodsShopcar record);

    int insertSelective(FsGoodsShopcar record);

    FsGoodsShopcar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsGoodsShopcar record);

    int updateByPrimaryKey(FsGoodsShopcar record);

    List<Shopcardto> findByMemberId(Integer id);
}
