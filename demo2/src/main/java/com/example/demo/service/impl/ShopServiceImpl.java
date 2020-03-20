package com.example.demo.service.impl;

import com.example.demo.entity.Shop;
import com.example.demo.exception.ToViewException;
import com.example.demo.mapper.ShopMapper;
import com.example.demo.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopMapper shopMapper;


    @Override
    public List<Shop> byAdmin(Integer adminId) {
        return shopMapper.findByAdminId(adminId);
    }

    @Override
    public Shop byUIdAndSId(Integer uId, Integer shopId) {
        return shopMapper.findByUserIdAndShopId(uId, shopId);
    }

    @Override
    public void newShop(Integer uId, String shopName) {


        Shop shop = shopMapper.findByName(shopName);
        if (shop != null) {
            throw new ToViewException("店名重复");
        }
        shop = new Shop();
        shop.setName(shopName);
        shop.setAdminId(uId);
        shopMapper.insertSelective(shop);
    }

}
