package com.eden.finance.goldcat.account.entity;

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
 * 账本
 * </p>
 *
 * @author xsm
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AccountBook对象", description="账本")
public class AccountBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账本ID")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer bookId;

    @ApiModelProperty(value = "账本名称")
    private String name;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "有效标志")
    private Boolean validflag;



}
