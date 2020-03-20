package com.example.demo.entity;

import java.math.BigDecimal;

public class Goods {
    /**
    * 商品id
    */
    private Integer id;

    /**
    * 商品名称
    */
    private String name;

    /**
    * 条形码
    */
    private String sn;

    /**
    * 进货价格
    */
    private BigDecimal costPrice;

    /**
    * 建议零售价
    */
    private BigDecimal salePrice;

    /**
    * 类别
    */
    private String type;

    /**
    * 门店id
    */
    private Integer shopId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                ", costPrice=" + costPrice +
                ", salePrice=" + salePrice +
                ", type='" + type + '\'' +
                ", shopId=" + shopId +
                '}';
    }
}