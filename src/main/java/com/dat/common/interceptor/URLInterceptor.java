package com.dat.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class URLInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("클라이언트가 접속함");
		System.out.println(request.getRemoteAddr()); //클라이언트의 IP
		
		//true를 리턴할 경우 Controller에게 요청을 넘긴다.
		//false를 리턴할 경우 Controller에게 요청을 넘기지 않고 응답처리 한다.
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("컨트롤러 실행을 끝마침!");
	}
}
