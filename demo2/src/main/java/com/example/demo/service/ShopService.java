package com.example.demo.service;

import com.example.demo.entity.Shop;

import java.util.List;

public interface ShopService {

    List<Shop> byAdmin(Integer adminId);

    Shop byUIdAndSId(Integer uId,Integer shopId);

    void newShop(Integer uId,String shopName);




}

