package com.fushuai.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value="com-fushuai-entity-Classes")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Classes implements Serializable {
    /**
    * 类别编号
    */
    @ApiModelProperty(value="类别编号")
    private Long id;

    /**
    * 类别名称
    */
    @ApiModelProperty(value="类别名称")
    private String cname;

    private static final long serialVersionUID = 1L;
}