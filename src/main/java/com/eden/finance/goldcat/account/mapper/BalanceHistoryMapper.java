package com.eden.finance.goldcat.account.mapper;

import com.eden.finance.goldcat.account.entity.BalanceHistory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 余额历史 Mapper 接口
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
public interface BalanceHistoryMapper extends Mapper<BalanceHistory> {

	List<BalanceHistory> queryMonth(Map<String, Object> map);

	void batchInsert(List<BalanceHistory> result);
}

