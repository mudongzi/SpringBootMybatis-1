package com.example.demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;


@Configuration
@EnableCaching
public class RedisConfiguration  {

	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		System.out.println("加载redis配置");
		return new RedisCacheManager(redisTemplate);
	}
	
	/**如下几个配置是配置linux中的redis
	 * 1.创建 JedisPoolConfig对象，该对象中完成一些连接池配置
	 * 
	 */
	
	/**@Bean
	public JedisPoolConfig jedisPoolConfig() {
		//也可以不配使用默认的,也饿可以配置在yml中
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(10);//最大空闲数
		config.setMaxTotal(20);//最大连接数
		return config;
	}
		*/
	/**
	 * 2.创建jedisConnectionFactory配置redis连接信息
	 */
	/**
	@Bean
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
		
		JedisConnectionFactory factory = new JedisConnectionFactory();
		//关联连接池
		factory.setPoolConfig(jedisPoolConfig);
		//配置链接redis信息
		//主机地址
		factory.setHostName("");
		//设置端口
		factory.setPort(6397);
		return factory;
	}
*/
	/**
	 * 3.创建RedisTemplate :用于执行redis操作方法
	 */
	/**
	public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory connectionFactory){
		RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		//为key序列化
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}
*/
}
