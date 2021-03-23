package com.eden.finance.goldcat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 账本
 * </p>
 *
 * @author xsm
 * @since 2021-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AccountBook对象", description="账本")
public class AccountBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账本ID")
    @TableId(value = "book_id", type = IdType.AUTO)
    private Integer bookId;

    @ApiModelProperty(value = "账本名称")
    private String name;

    @ApiModelProperty(value = "有效标志")
    private Integer delflag;


}
