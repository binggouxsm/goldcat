package com.eden.finance.goldcat.record.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.eden.finance.goldcat.record.service.RecordService;

import java.util.Map;

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

	@PostMapping("/import")
	public void importRecord(@RequestBody Map<String,String> map) throws Throwable {
		recordService.importRecord(map);
	}
}

