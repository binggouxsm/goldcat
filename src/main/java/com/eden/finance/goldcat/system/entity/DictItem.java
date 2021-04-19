package com.eden.finance.goldcat.system.entity;

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
 * 字典表
 * </p>
 *
 * @author xsm
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DictItem对象", description="字典表")
public class DictItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典ID")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer itemId;

    @ApiModelProperty(value = "字典类型")
    private String type;

    @ApiModelProperty(value = "字典码值")
    private String code;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "字典顺序")
    private Integer itemOrder;

    @ApiModelProperty(value = "有效标志")
    private Boolean validflag;



}
