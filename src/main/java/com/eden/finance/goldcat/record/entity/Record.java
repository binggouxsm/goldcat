package com.eden.finance.goldcat.record.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import javax.persistence.Id;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 记账记录
 * </p>
 *
 * @author xsm
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Record对象", description="记账记录")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记账记录ID")
    @Id
    private String recordId;

    @ApiModelProperty(value = "类型：收入、支出、转账")
    private Integer recordType;

    @ApiModelProperty(value = "具体类型")
    private Integer recordTypeId;

    @ApiModelProperty(value = "账户")
    private Integer accountId;

    @ApiModelProperty(value = "实际支付账户，该字段针对微信、支付宝等虚拟账户")
    private Integer realAccountId;

    @ApiModelProperty(value = "币别")
    private String currency;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "信息来源：微信，支付宝等等")
    private String source;

    @ApiModelProperty(value = "交易时间")
    private LocalDateTime happenTime;

    @ApiModelProperty(value = "商户信息")
    private String party;

    @ApiModelProperty(value = "商品信息")
    private String product;

    @ApiModelProperty(value = "交易状态")
    private String status;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "有效标志")
    private Boolean validflag;



}
