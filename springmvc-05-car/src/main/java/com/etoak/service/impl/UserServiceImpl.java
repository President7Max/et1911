package com.etoak.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.User;
import com.etoak.mapper.UserMapper;
import com.etoak.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper mapperUser;
	
	@Override
	public User getById(int id) {
		return mapperUser.getById(id);
	}
	

}
