package com.eden.finance.goldcat.account.entity;

import java.math.BigDecimal;
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
 * 账户
 * </p>
 *
 * @author xsm
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Account对象", description="账户")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户ID")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer accountId;

    @ApiModelProperty(value = "所属账本")
    private Integer bookId;

    @ApiModelProperty(value = "账户名称")
    private String name;

    @ApiModelProperty(value = "账户号")
    private String accountNo;

    @ApiModelProperty(value = "账户类别")
    private Integer type;

    @ApiModelProperty(value = "账户币别")
    private String currency;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "当月收入累计金额")
    private BigDecimal monthIn;

    @ApiModelProperty(value = "当月支出累计金额")
    private BigDecimal monthOut;

    @ApiModelProperty(value = "当月转出累计金额")
    private BigDecimal monthTransfer;

    @ApiModelProperty(value = "有效标志")
    private Boolean validflag;



}
