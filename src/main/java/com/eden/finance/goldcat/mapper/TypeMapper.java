package com.eden.finance.goldcat.mapper;

import com.eden.finance.goldcat.entity.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 类型 Mapper 接口
 * </p>
 *
 * @author xsm
 * @since 2021-03-23
 */
public interface TypeMapper extends BaseMapper<Type> {

    public List<Type> getChildren(int typeId);

}
