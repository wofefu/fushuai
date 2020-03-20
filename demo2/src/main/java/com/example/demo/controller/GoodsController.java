package com.example.demo.controller;


import com.example.demo.annotation.HasRole;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Shop;
import com.example.demo.exception.ToViewException;
import com.example.demo.service.GoodsService;
import com.example.demo.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GoodsController {
    private final ShopService shopService;

    private final GoodsService goodsService;

    public GoodsController(ShopService shopService, GoodsService goodsService) {
        this.shopService = shopService;
        this.goodsService = goodsService;
    }

    @GetMapping("/user/{uId}/shop/{shopId}/addGoods")
    @HasRole(value = "SHOP_MANAGER", id = "#uId")
    public String addGoods(@PathVariable Integer uId, @PathVariable Integer shopId, Model model) {
        Shop shop = shopService.byUIdAndSId(uId, shopId);
        model.addAttribute("shop", shop);
        return "addGoods";
    }

    @PostMapping("/user/{uId}/shop/{shopId}/addGoods")
    @ResponseBody
    @HasRole(value = "SHOP_MANAGER", id = "#uId")
    public String addGoods(@RequestBody List<Goods> goods, @PathVariable Integer uId,
                           @PathVariable Integer shopId) {
        //为了避免前端对shopId的修改  通过查询出指定的Shop 为goods中的shopId去赋值 而不是简单接收前端
        Shop shop = shopService.byUIdAndSId(uId, shopId);
        if (shop == null) {
            throw new ToViewException("门店信息错误");
        }
        goods.forEach(g -> g.setShopId(shop.getId()));
        goodsService.addGoods(goods);
        return "success";
    }
}
