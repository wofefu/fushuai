package fushuai.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "fushuai-entity-FsGoods")
public class FsGoods implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "")
    private String typeid;

    @ApiModelProperty(value = "")
    private String goodsname;

    @ApiModelProperty(value = "")
    private String introduce;

    @ApiModelProperty(value = "")
    private Double price;

    @ApiModelProperty(value = "")
    private Double nowprice;

    @ApiModelProperty(value = "")
    private String picture;

    @ApiModelProperty(value = "")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date intime;

    @ApiModelProperty(value = "")
    private String newgoods;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getNowprice() {
        return nowprice;
    }

    public void setNowprice(Double nowprice) {
        this.nowprice = nowprice;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public String getNewgoods() {
        return newgoods;
    }

    public void setNewgoods(String newgoods) {
        this.newgoods = newgoods;
    }
}