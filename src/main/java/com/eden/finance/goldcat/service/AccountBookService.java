package com.eden.finance.goldcat.service;

import com.eden.finance.goldcat.entity.AccountBook;
import com.eden.finance.goldcat.mapper.AccountBookMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 账本 服务类
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@Service
public class AccountBookService {

	@Autowired
	private AccountBookMapper accountBookMapper;

	public List<AccountBook> queryBook(AccountBook book){
		return accountBookMapper.select(book);
	}
}


