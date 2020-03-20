package com.example.demo.controller;

import com.example.demo.annotation.HasRole;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Shop;
import com.example.demo.exception.ToViewException;
import com.example.demo.service.GoodsService;
import com.example.demo.service.ShopService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ShopController {

    private final ShopService shopService;
    private final GoodsService goodsService;

    public ShopController(ShopService shopService, GoodsService goodsService) {
        this.shopService = shopService;
        this.goodsService = goodsService;
    }

    @GetMapping("/shop_admin/{uId}")
    @HasRole(value = "SHOP_MANAGER", id = "#uId")
    public String shopManager(@PathVariable Integer uId, Model model) {

        List<Shop> shops = shopService.byAdmin(uId);
        model.addAttribute("shops", shops);
        return "shop_admin";
    }

    @GetMapping("/user/{uId}/shop/{shopId}")
    @HasRole(value = {"SHOP_MANAGER", "SALESMAN"}, id = "#uId")
    public String toShop(@PathVariable Integer uId, @PathVariable Integer shopId, Model model,
                         String type,String name,Integer pageIndex) {
        //为了防止 用户访问到它无权访问的商店 要怎么处理
        Shop shop = shopService.byUIdAndSId(uId, shopId);
        System.out.println(name);
        System.out.println(type);

        if(shop==null){
            throw new ToViewException("商店信息错误");
        }

        //查询商品信息
        PageInfo<Goods> goodsInfo = goodsService.byShopId(shopId,pageIndex,type,name);
        model.addAttribute("goodsInfo",goodsInfo);
        model.addAttribute("shop", shop);
        return "shop";
    }


}
