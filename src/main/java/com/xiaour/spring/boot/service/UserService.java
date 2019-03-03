package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.UserInfo;

public interface UserService {
	
	UserInfo findInfoById(Integer id);

	UserInfo findByUsername(String username);
	
}
