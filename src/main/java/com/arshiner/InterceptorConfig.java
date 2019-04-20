package com.arshiner;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 加载静态文件必须在这个目录下
 * @author 士林
 *
 */
@Configuration
@EnableWebMvc
public class InterceptorConfig implements  WebMvcConfigurer   {

	
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		 //在系统中添加 拦截器
//	        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login","/static/**");
	 }

	

	@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
	    }  
}  
