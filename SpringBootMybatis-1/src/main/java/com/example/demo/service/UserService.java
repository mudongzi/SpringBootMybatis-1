package com.example.demo.service;


import com.example.demo.pojo.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

	public User findUser(String userName, String userPwd);
	
	
	public PageInfo<User> findAllUser1(Integer currentPage,int pageSize);
}
