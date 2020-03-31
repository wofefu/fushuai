package com.fuhsuai.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
    * 新闻表
    */
@ApiModel(value="com-fuhsuai-entity-NewsDetail")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewsDetail implements Serializable {
    /**
    * 新闻编号
    */
    @ApiModelProperty(value="新闻编号")
    private Long id;

    /**
    * 新闻分类编号
    */
    @ApiModelProperty(value="新闻分类编号")
    private Long categoryid;

    /**
    * 新闻标题
    */
    @ApiModelProperty(value="新闻标题")
    private String title;

    /**
    * 新闻摘要
    */
    @ApiModelProperty(value="新闻摘要")
    private String summary;

    /**
    * 作者
    */
    @ApiModelProperty(value="作者")
    private String author;

    /**
    * 创建时间
    */
    @JSONField(format = "yyyy-MM-dd hh:mm")
    @ApiModelProperty(value="创建时间")
    private Date createdate;

    /**
    * 更新时间
    */
    @JSONField(format = "yyyy-MM-dd hh:mm")
    @ApiModelProperty(value="更新时间")
    private Date updatedate;


    private String name;

    private static final long serialVersionUID = 1L;
}