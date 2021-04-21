package com.eden.finance.goldcat.account.controller;


import com.eden.finance.goldcat.account.entity.Account;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.eden.finance.goldcat.account.service.AccountService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账户 前端控制器
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("")
	public void addAccount(@RequestBody Account account){
		accountService.addAccount(account);
	}

	@PostMapping("query")
	public List<Account> queryAccount(@RequestBody Account account){
		account.setValidflag(true);
		return accountService.queryAccount(account);
	}

	@PostMapping("queryByType")
	public Map<String, List<Account>> queryAccountByType(@RequestBody Account account){
		account.setValidflag(true);
		Map<String, List<Account>> ret = new HashMap<>();
		List<Account> accounts = accountService.queryAccount(account);
		for(Account acc : accounts){
			List<Account> accountList = ret.get(acc.getType());
			if( accountList == null){
				accountList = new ArrayList<>();
				ret.put(acc.getType(), accountList);
			}
			accountList.add(acc);
		}
		return ret;
	}

	@DeleteMapping("")
	public void deleteAccount(@RequestBody Account account){
		accountService.deleteAccount(account);
	}
}

