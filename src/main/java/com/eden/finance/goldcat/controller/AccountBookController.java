package com.eden.finance.goldcat.controller;


import com.eden.finance.goldcat.entity.AccountBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.eden.finance.goldcat.service.AccountBookService;

import java.util.List;

/**
 * <p>
 * 账本 前端控制器
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/accountBook")
public class AccountBookController {

	@Autowired
	private AccountBookService accountBookService;

	@GetMapping("")
	public List<AccountBook> queryBook(){
		AccountBook book = new AccountBook();
		book.setValidflag(true).setUserId(1);
		return accountBookService.queryBook(book);
	}
}

