package com.arshiner;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
		//如果session参数不为空，说明已经登录，拥有权限，返回true继续访问。
//		if(request.getSession().getAttribute("session参数")!=null){
//			return true;
//		}
//		//如果session参数为空，说明没有登录，返回false,可配置重定向跳转到登录页面
//		response.sendRedirect("/");
		return false;
	}
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView){
		System.out.println("在请求不报异常，顺利完成后执行");
	}
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
		System.out.println("无论请求是否异常，最后都会执行。用于清理资源，关闭连接等");
	}
}

