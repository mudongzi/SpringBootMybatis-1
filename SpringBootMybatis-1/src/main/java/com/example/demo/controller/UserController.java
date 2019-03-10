package com.example.demo.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("user")
@Api("UserController相关的API")
public class UserController {
	
	
	@Resource
	private  UserService userService;
	
	@RequestMapping("tologin")
	public String toLogin(Model model) {
		System.out.println("去登陆12121");
		return "/login";
	}
	@ApiOperation("获取用户登录信息")
	  @ApiImplicitParams({
	        @ApiImplicitParam(paramType="header",name="userName",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang"),
	        @ApiImplicitParam(paramType="query",name="userPwd",dataType="String",required=true,value="用户的密码",defaultValue="wangna")
	    })
	    @ApiResponses({
	        @ApiResponse(code=400,message="请求参数没填好"),
	        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
	    })
	@Valid
	@RequestMapping("login")
	public String login(String userName,String userPwd,HttpSession session,Model model,Map<String, Object>  map) {
		System.out.println("進來登陸");
		User user = userService.findUser(userName, userPwd);
		System.out.println(userName+userPwd);
		
		if(user !=null) {
			System.out.println(userName+userPwd);
			session.setAttribute("user", userName);
			model.addAttribute("user", userPwd);
			return "index";
		}
		map.put("error", "登录错误");
		return "/login";
	}
	/**
	 * http://127.0.0.1:8080/user/itemsPage?currentPage=1
	 * @Title: itemsPage1  
	 * @Description:   
	 * @param currentPage
	 * @param model
	 * @return
	 */
    @RequestMapping("/itemsPage1")
    public String itemsPage1(int currentPage,Model model){
    	System.out.println(currentPage);
    	PageInfo<User> beanList = userService.findAllUser1(currentPage, 4);
        
         model.addAttribute("userList", beanList);
         return "pageList";
    }
   
   @GetMapping("/user/{userName}")
	public String getUser(@PathVariable("userName") String userName ) {
		
	   return"updateUser";
	}
	
}
