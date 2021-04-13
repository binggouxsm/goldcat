package com.eden.finance.goldcat.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.eden.finance.goldcat.service.RecordService;

/**
 * <p>
 * 记账记录 前端控制器
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/record")
public class RecordController {

	@Autowired
	private RecordService recordService;
}

