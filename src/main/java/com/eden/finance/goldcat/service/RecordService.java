package com.eden.finance.goldcat.service;

import com.eden.finance.goldcat.entity.Record;
import com.eden.finance.goldcat.mapper.RecordMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 * 记账记录 服务类
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@Service
public class RecordService {

	@Autowired
	private RecordMapper recordMapper;
}


