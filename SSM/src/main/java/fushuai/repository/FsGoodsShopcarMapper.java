package fushuai.repository;
import org.apache.ibatis.annotations.Param;

import fushuai.dto.Shopcardto;
import fushuai.entity.FsGoodsShopcar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FsGoodsShopcarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FsGoodsShopcar record);

    int insertSelective(FsGoodsShopcar record);

    FsGoodsShopcar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsGoodsShopcar record);

    int updateByPrimaryKey(FsGoodsShopcar record);

    /**
     * 查询当前用户购物车信息
     * @param id  用户id
     * @return
     */
    List<Shopcardto> findByMemberId(Integer id);

    List<Shopcardto> findAll();


}