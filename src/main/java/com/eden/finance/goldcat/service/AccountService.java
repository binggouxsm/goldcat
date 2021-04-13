package com.eden.finance.goldcat.service;

import cn.hutool.core.bean.BeanUtil;
import com.eden.finance.goldcat.entity.Account;
import com.eden.finance.goldcat.entity.BalanceHistory;
import com.eden.finance.goldcat.mapper.AccountMapper;
import com.eden.finance.goldcat.mapper.BalanceHistoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 账户 服务类
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@Service
public class AccountService {

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private BalanceHistoryMapper balanceHistoryMapper;

	public void addAccount(Account account) {
		if(account.getAccountId() == null){
			accountMapper.insertSelective(account);
		}else {
			accountMapper.updateByPrimaryKeySelective(account);
		}
		BalanceHistory hist = BeanUtil.copyProperties(account, BalanceHistory.class);
		hist.setHisdate(LocalDate.now());
		if(balanceHistoryMapper.existsWithPrimaryKey(hist)){
			balanceHistoryMapper.updateByPrimaryKeySelective(hist);
		}else {
			balanceHistoryMapper.insertSelective(hist);
		}
		System.out.println("===");

	}

	public List<Account> queryAccount(Account account) {
		return accountMapper.select(account);
	}

	public void  deleteAccount(Account account){
		account.setValidflag(false);
		accountMapper.updateByPrimaryKeySelective(account);
	}
}


