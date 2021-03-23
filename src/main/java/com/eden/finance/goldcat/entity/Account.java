package com.eden.finance.goldcat.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 账户
 * </p>
 *
 * @author xsm
 * @since 2021-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Account对象", description="账户")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户ID")
    @TableId(value = "account_id", type = IdType.AUTO)
    private Integer accountId;

    @ApiModelProperty(value = "所属账本")
    private Integer bookId;

    @ApiModelProperty(value = "账户名称")
    private String name;

    @ApiModelProperty(value = "账户类别")
    private Integer type;

    @ApiModelProperty(value = "账户币别")
    private String currency;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "有效标志")
    private Integer delflag;


}
