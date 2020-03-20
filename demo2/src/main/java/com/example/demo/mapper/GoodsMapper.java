package com.example.demo.mapper;
import com.example.demo.entity.Goods;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface GoodsMapper {

    //批量入库 一次性在商品表中插入多个商品
    int insertList(@Param("list")List<Goods> list);


    /**
     * 动态查询门店的货物列表
     * @param shopId 门店id
     * @param type 类型 非必填
     * @param name 名称 非必填
     * @return 货物列表
     */
    List<Goods> findByShopIdAndTypeAndName(@Param("shopId")Integer shopId,@Param("type")String type,@Param("name")String name);


    List<Goods> findByShopIdAndTypeAndNameLike(@Param("shopId")Integer shopId,@Param("type")String type,@Param("likeName")String likeName);











}