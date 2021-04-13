package com.eden.finance.goldcat.mapper;

import com.eden.finance.goldcat.entity.DictItem;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
public interface DictItemMapper extends Mapper<DictItem> {

	List<DictItem> queryCode(String type);

}

