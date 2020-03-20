package com.example.demo.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Shop;

public interface ShopMapper {

    List<Shop> findByAdminId(@Param("adminId")Integer adminId);


    Shop findByUserIdAndShopId(@Param("userId")Integer userId,
                               @Param("shopId")Integer shopId);


    int insertSelective(Shop shop);

    Shop findByName(@Param("name")String name);











}