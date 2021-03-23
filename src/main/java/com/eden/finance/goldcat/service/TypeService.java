package com.eden.finance.goldcat.service;

import com.eden.finance.goldcat.entity.Type;
import com.eden.finance.goldcat.entity.enums.TypeCode;
import com.eden.finance.goldcat.mapper.TypeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
    * 类型 服务实现类
    * </p>
*
* @author xsm
* @since 2021-03-23
*/
@Service
public class TypeService extends ServiceImpl<TypeMapper, Type>  {

    @Cacheable(cacheNames="types",keyGenerator = "keyGenerator")
    public List<Type> getChildren(TypeCode type){
        return this.getChildren(type.getValue());
    }


    public List<Type> getChildren(int typeId) {
        return baseMapper.getChildren(typeId);
    }
}
