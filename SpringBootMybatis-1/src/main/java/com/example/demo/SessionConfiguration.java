package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {
   //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            //注册拦截器
        	@Override
        	public void addInterceptors(InterceptorRegistry registry) {
        		// TODO Auto-generated method stub
        		registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/tologin","/","/user/login");
        	}
		
        };
        return adapter;
    }

	
	
	
}
