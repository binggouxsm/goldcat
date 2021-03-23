package com.eden.finance.goldcat.controller;

import com.eden.finance.goldcat.entity.DictItem;
import com.eden.finance.goldcat.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author xsm
 * @since 2021-03-23
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
