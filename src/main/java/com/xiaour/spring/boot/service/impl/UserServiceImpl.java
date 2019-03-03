package com.xiaour.spring.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaour.spring.boot.entity.UserInfo;
import com.xiaour.spring.boot.mapper.UserInfoMapper;
import com.xiaour.spring.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfo findInfoById(Integer id) {
		UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
		return userInfo;
	}

	@Override
	public UserInfo findByUsername(String username) {
		return userInfoMapper.selectByUserName(username);
	}

}
