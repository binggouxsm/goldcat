package com.eden.finance.goldcat.entity;

import tk.mybatis.mapper.annotation.KeySql;
import java.io.Serializable;
import javax.persistence.Id;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 类型
 * </p>
 *
 * @author xsm
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Type对象", description="类型")
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型ID")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer typeId;

    @ApiModelProperty(value = "类型名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "有效标志")
    private Boolean validflag;



}
