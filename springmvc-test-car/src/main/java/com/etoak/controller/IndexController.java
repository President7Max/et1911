package com.etoak.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;

@Controller
public class IndexController {
	
	List<User> userList = new ArrayList<User>();
	
	@RequestMapping("/addUser")
	@ResponseBody
	public String add(User user) {
		System.out.println(Thread.currentThread().getName());
		userList.add(user);
		return "add Success";
	}
	
	@RequestMapping("/queryAll")
	@ResponseBody
	public List<User> queryUser(){
		System.out.println(Thread.currentThread().getName());
		return userList;
	}
	
	@RequestMapping("/add")
	public String index(HttpServletRequest request) {
		request.setAttribute("user", new User(1,"requestUser","",20));
		request.getSession().setAttribute("sessionUser", new User(2,"sessionUser","",21));
		
		List<User> userList = new ArrayList<>();
		request.setAttribute("userList", userList);
		userList.add(new User(3,"张三","",28));
		userList.add(new User(4,"李四","",25));
		
		return "index";
		
	}
	
}
