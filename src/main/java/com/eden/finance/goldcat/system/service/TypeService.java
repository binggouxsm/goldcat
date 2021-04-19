package com.eden.finance.goldcat.system.service;

import com.eden.finance.goldcat.system.entity.Type;
import com.eden.finance.goldcat.system.entity.enums.TypeCode;
import com.eden.finance.goldcat.system.mapper.TypeMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 类型 服务类
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@Service
public class TypeService {

	@Autowired
	private TypeMapper typeMapper;

	@Cacheable(cacheNames="types",keyGenerator = "keyGenerator")
	public List<Type> getChildren(TypeCode type){
		return this.getChildren(type.getValue());
	}


	public List<Type> getChildren(int typeId) {
		return typeMapper.getChildren(typeId);
	}
}


