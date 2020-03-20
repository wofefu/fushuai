package com.example.demo.service;

import com.example.demo.entity.Goods;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsService {


    void addGoods(List<Goods> goodsList);

    PageInfo<Goods> byShopId(Integer shopId, Integer pageIndex,String type,String name);


}
