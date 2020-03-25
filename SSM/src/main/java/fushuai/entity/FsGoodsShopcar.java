package fushuai.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="fushuai-entity-FsGoodsShopcar")
public class FsGoodsShopcar implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Integer memberid;

    /**
    * 商品id
    */
    @ApiModelProperty(value="商品id")
    private Integer goodsid;

    /**
    * 商品数量
    */
    @ApiModelProperty(value="商品数量")
    private Integer num;

    /**
    * 记录状态。1，正常 2：禁用  3：删除
    */
    @ApiModelProperty(value="记录状态。1，正常 2：禁用  3：删除")
    private Byte status;

    /**
    * 记录商品加入购物车的创建时间
    */
    @ApiModelProperty(value="记录商品加入购物车的创建时间")
    private Date createtime;

    /**
    * 记录购物车中该商品的更新时间，入更改里面的内容，数量等
    */
    @ApiModelProperty(value="记录购物车中该商品的更新时间，入更改里面的内容，数量等")
    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}