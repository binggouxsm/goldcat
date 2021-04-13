package com.eden.finance.goldcat.service;

import com.eden.finance.goldcat.entity.UserInfo;
import com.eden.finance.goldcat.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author xsm
 * @since 2021-03-31
 */
@Service
public class UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
}


