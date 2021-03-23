package com.eden.finance.goldcat.controller;


import cn.hutool.core.bean.BeanUtil;
import com.eden.finance.goldcat.entity.Account;
import com.eden.finance.goldcat.entity.BalanceHistory;
import com.eden.finance.goldcat.service.AccountService;
import com.eden.finance.goldcat.service.BalanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * <p>
 * 账户 前端控制器
 * </p>
 *
 * @author xsm
 * @since 2021-03-23
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BalanceHistoryService balanceHistoryService;

    @PostMapping("")
    public void saveOrUpdate(@RequestBody Account account){
        accountService.saveOrUpdate(account);
        BalanceHistory history = BeanUtil.copyProperties(account, BalanceHistory.class);
        history.setHisdate(LocalDate.now());
        balanceHistoryService.saveOrUpdate(history);
    }

}
