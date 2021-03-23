package com.eden.finance.goldcat.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 余额历史
 * </p>
 *
 * @author xsm
 * @since 2021-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BalanceHistory对象", description="余额历史")
public class BalanceHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "余额历史ID")
    @TableId(value = "balance_history_id", type = IdType.AUTO)
    private Integer balanceHistoryId;

    @ApiModelProperty(value = "账户")
    private Integer accountId;

    @ApiModelProperty(value = "历史日期")
    private LocalDate hisdate;

    @ApiModelProperty(value = "账户币别")
    private String currency;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "是否月末")
    private Integer isMonth;

    @ApiModelProperty(value = "是否季末")
    private Integer isSeason;

    @ApiModelProperty(value = "是否年末")
    private Integer isYear;

    @ApiModelProperty(value = "有效标志")
    private Integer delflag;


}
