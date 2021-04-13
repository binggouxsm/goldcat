package com.eden.finance.goldcat.controller;


import com.eden.finance.goldcat.entity.Account;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.eden.finance.goldcat.service.AccountService;

import java.util.List;

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

	@DeleteMapping("")
	public void deleteAccount(@RequestBody Account account){
		accountService.deleteAccount(account);
	}
}

