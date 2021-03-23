package com.eden.finance.goldcat.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eden.finance.goldcat.entity.DictItem;
import com.eden.finance.goldcat.mapper.DictItemMapper;
import com.eden.finance.goldcat.service.DictItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
    * 字典表 服务实现类
    * </p>
*
* @author xsm
* @since 2021-03-23
*/
@Service
public class DictItemService extends ServiceImpl<DictItemMapper, DictItem>  {

    public List<DictItem> getCode(String code) {
        QueryWrapper<DictItem> query = new QueryWrapper<>();
        query.lambda().eq(DictItem::getType,code).orderByAsc(DictItem::getItemOrder);
        return baseMapper.selectList(query);
    }

}
