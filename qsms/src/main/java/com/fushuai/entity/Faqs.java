package com.fushuai.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value="com-fushuai-entity-Faqs")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Faqs implements Serializable {
    /**
    * 问题编号
    */
    @ApiModelProperty(value="问题编号")
    private Long id;

    /**
    * 标题
    */
    @ApiModelProperty(value="标题")
    private String title;

    /**
    * 创建时间，去系统当前时间
    */
    @JSONField(format = "yyyy-MM-dd")
    @ApiModelProperty(value="创建时间，去系统当前时间")
    private Date createdate;

    /**
    * 内容
    */
    @ApiModelProperty(value="内容")
    private String content;

    /**
    * 类别编号
    */
    @ApiModelProperty(value="类别编号")
    private Long classid;

    private String cname;

    private static final long serialVersionUID = 1L;
}