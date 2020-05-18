package com.etoak.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etoak.action.UserAction;
import com.etoak.service.UserService;

/*
 * config相当于xml的根元素<bean>标签
 * 表示这是一个spring ioc容器
 * */

@Configuration
public class UserConfig {
	
	@Bean("userService")
	public UserService userService() {
		return new UserService();
	}
	
	@Bean()
	public UserAction userAction(@Qualifier("userService")UserService userService) {
		UserAction userAction = new UserAction();
		
		//配合@Qualifier使用
		userAction.setUserService(userService);
		return userAction;
	}
	
}
