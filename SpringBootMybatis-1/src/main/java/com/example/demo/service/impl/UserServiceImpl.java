package com.example.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@CacheConfig(cacheNames="user")
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Cacheable
	public User findUser(String userName, String userPwd) {
		User user = userMapper.getUser(userName, userPwd);
		return user;
	}

	@Cacheable
	
	public PageInfo<User> findAllUser1(Integer currentPage,int pageSize) {
		  PageHelper.startPage(currentPage, pageSize);
	        
			List<User> list = userMapper.selectAllUser();
			//设置总记录数List<T> list, int navigatePages
			 int countNums = list.size();
			 PageInfo<User> pageData = new PageInfo<>(list);
			 pageData.setTotal(countNums);
		     return pageData;
	}


	

}
