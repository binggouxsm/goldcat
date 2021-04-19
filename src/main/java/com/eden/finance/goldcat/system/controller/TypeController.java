package com.eden.finance.goldcat.system.controller;


import com.eden.finance.goldcat.system.entity.Type;
import com.eden.finance.goldcat.system.entity.enums.TypeCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.eden.finance.goldcat.system.service.TypeService;

import java.util.List;

/**
 * <p>
 * 类型 前端控制器
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private TypeService typeService;

	@GetMapping("/{type}")
	public List<Type> getChildren(@PathVariable String type){
		return typeService.getChildren(TypeCode.valueOf(type));
	}
}

