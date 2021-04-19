package com.eden.finance.goldcat.account.service;

import com.eden.finance.goldcat.account.mapper.BalanceHistoryMapper;
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

	public void recalBalanceHistory(String yearMonth){
		


	}
}


