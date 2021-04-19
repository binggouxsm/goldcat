package com.eden.finance.goldcat.system.controller;


import com.eden.finance.goldcat.system.entity.DictItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.eden.finance.goldcat.system.service.DictItemService;

import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/dictItem")
public class DictItemController {

	@Autowired
	private DictItemService dictItemService;

	@GetMapping("/{code}")
	public List<DictItem> getCode(@PathVariable String code){
		return dictItemService.getCode(code);
	}
}

