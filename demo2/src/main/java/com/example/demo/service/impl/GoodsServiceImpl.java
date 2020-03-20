package com.example.demo.service.impl;

import com.example.demo.entity.Goods;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    private final GoodsMapper goodsMapper;

    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public void addGoods(List<Goods> goodsList) {
        goodsMapper.insertList(goodsList);
    }

    @Override
    public PageInfo<Goods> byShopId(Integer shopId, Integer pageIndex, String type, String name) {
        if(pageIndex==null){
            pageIndex=1;
        }
        PageHelper.startPage(pageIndex, 20);

        List<Goods> goods =goodsMapper.findByShopIdAndTypeAndNameLike(shopId, type, name);
        return new PageInfo<>(goods);
    }
}
