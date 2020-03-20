package com.example.demo.controller;

import com.example.demo.annotation.HasRole;
import com.example.demo.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopManageController {

    private final ShopService shopService;

    public ShopManageController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/addShop")
    @HasRole(value = "SHOP_MANAGER", id = "#uId")
    public String addShop(String shopName, Integer uId) {
        shopService.newShop(uId, shopName);
        return "redirect:shop_admin/"+uId;
    }

    @GetMapping("/addShop")
    public String addShop() {
        return "addShop";
    }
}
