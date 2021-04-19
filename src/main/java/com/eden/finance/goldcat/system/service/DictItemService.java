package com.eden.finance.goldcat.system.service;

import com.eden.finance.goldcat.system.entity.DictItem;
import com.eden.finance.goldcat.system.mapper.DictItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@Service
public class DictItemService {

	@Autowired
	private DictItemMapper dictItemMapper;

	public List<DictItem> getCode(String code) {
		return dictItemMapper.queryCode(code);
	}
}


