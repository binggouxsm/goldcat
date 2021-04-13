package com.eden.finance.goldcat.service;

import com.eden.finance.goldcat.entity.BalanceHistory;
import com.eden.finance.goldcat.mapper.BalanceHistoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 * 余额历史 服务类
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@Service
public class BalanceHistoryService {

	@Autowired
	private BalanceHistoryMapper balanceHistoryMapper;
}


