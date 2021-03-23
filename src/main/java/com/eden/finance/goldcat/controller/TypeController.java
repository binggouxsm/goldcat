package com.eden.finance.goldcat.controller;


import com.eden.finance.goldcat.entity.Type;
import com.eden.finance.goldcat.entity.enums.TypeCode;
import com.eden.finance.goldcat.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 类型 前端控制器
 * </p>
 *
 * @author xsm
 * @since 2021-03-23
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
