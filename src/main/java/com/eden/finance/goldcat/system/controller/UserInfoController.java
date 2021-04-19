package com.eden.finance.goldcat.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.eden.finance.goldcat.system.service.UserInfoService;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author xsm
 * @since 2021-03-31
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;





}

