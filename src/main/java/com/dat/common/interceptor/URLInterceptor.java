package com.dat.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class URLInterceptor extends HandlerInterceptorAdapter{

	/*private Logger logger = LoggerFactory.getLogger(URLInterceptor.class);*/
	private Logger logger = LoggerFactory.getLogger("interceptor");
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("클라이언트가 접속함");
		logger.info(request.getRemoteAddr()); //클라이언트의 IP
		
		//true를 리턴할 경우 Controller에게 요청을 넘긴다.
		//false를 리턴할 경우 Controller에게 요청을 넘기지 않고 응답처리 한다.
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.debug("컨트롤러 실행을 끝마침!");
	}
}
