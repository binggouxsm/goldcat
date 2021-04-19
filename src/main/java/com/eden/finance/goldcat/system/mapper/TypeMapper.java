package com.eden.finance.goldcat.system.mapper;

import com.eden.finance.goldcat.system.entity.Type;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * <p>
 * 类型 Mapper 接口
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
public interface TypeMapper extends Mapper<Type> {
	public List<Type> getChildren(int typeId);
}

