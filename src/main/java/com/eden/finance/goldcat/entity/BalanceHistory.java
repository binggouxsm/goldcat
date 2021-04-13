package com.eden.finance.goldcat.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.Id;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 余额历史
 * </p>
 *
 * @author xsm
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BalanceHistory对象", description="余额历史")
public class BalanceHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户")
    @Id
    private Integer accountId;

    @ApiModelProperty(value = "历史日期")
    @Id
    private LocalDate hisdate;

    @ApiModelProperty(value = "账户币别")
    private String currency;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "是否月末")
    private Boolean isMonth;

    @ApiModelProperty(value = "是否季末")
    private Boolean isSeason;

    @ApiModelProperty(value = "是否年末")
    private Boolean isYear;



}
