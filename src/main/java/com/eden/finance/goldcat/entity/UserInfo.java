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
 * 用户
 * </p>
 *
 * @author xsm
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserInfo对象", description="用户")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "有效标志")
    private Boolean validflag;



}
