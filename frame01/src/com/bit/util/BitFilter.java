package com.bit.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
//value´Â default°ªÀÓ
public class BitFilter implements Filter {
	
	String msg;

	@Override
	public void destroy() {
		System.out.println("BitFilter dest");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("BitFilter before do");
//		Enumeration<String> names=null;
//		names= req.getServletContext().getInitParameterNames();
//		
//		while(names.hasMoreElements()){
//			System.out.println(names.nextElement());
//		}
//		
		System.out.println("init Filter param = "+this.msg);
		chain.doFilter(req, resp);
		System.out.println("BitFilter after do");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("BitFilter init");
//		Enumeration<String> names=null;
//		names= config.getInitParameterNames();
//		
//		while(names.hasMoreElements()){
//			System.out.println(names.nextElement());
//		}
		this.msg=config.getInitParameter("msg2");
	}

}
