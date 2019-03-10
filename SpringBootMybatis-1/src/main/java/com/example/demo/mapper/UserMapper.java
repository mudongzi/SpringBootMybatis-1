package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.User;

@Mapper
public interface UserMapper {
	
	@Select("select * from user where userName= #{userName1} and userPwd= #{userPwd}")
	public User getUser(@Param(value = "userName1")String userName1, @Param(value = "userPwd")String userPwd);
	@Insert("insert into user values (#{userName},#{userPwd})")
	public int insertUser(@Param(value = "userName")String userName, @Param(value = "userPwd")String userPwd);
	//order by goodsId DESC limit #{startSize},#{size}
	@Select("select * from user")
	public List<User> selectAllUser();
	/*@Select("select * from user order by userName DESC limit #{currentPage},#{pageSize}")
	public List<User> selectAllUserPage(@Param(value = "currentPage")Integer currentPage  ,@Param(value = "pageSize")Integer pageSize  );*/
	
}
