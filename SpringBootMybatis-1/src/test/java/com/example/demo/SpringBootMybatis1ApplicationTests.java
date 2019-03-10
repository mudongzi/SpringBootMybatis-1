package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatis1ApplicationTests {
	@Autowired
	UserService us;
    @Autowired
	UserMapper um;
//    @Autowired
//    RedisTemplate<String,Object> templeate;
	@Test
	public void contextLoads() {
		User user = um.getUser("we", "1234");
		System.out.println(user);
		User user2 = um.getUser("we", "1234");
		System.out.println(user2);
//		templeate.opsForValue().set("key", "doubi");
//		System.out.println(templeate.opsForValue().get("key"));
	}
	@Test
	public void insertUser() {
		int num = um.insertUser("we", "1234");
		System.out.println(num);
	}
	
	
	
}
