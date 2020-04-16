package fushuai.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
    * 新闻分类表
    */
@ApiModel(value="com-fuhsuai-entity-NewsCategory")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategory implements Serializable {
    /**
    * 新闻分类编号
    */
    @ApiModelProperty(value="新闻分类编号")
    private Long id;

    @ApiModelProperty(value="")
    private String name;

    private static final long serialVersionUID = 1L;
}