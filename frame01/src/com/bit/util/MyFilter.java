package com.bit.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;

@WebFilter("/*")
public class MyFilter implements Filter {
	
	Logger log = Logger.getLogger("com.bit.util.MyFilter");
	
	
	@Override
	public void destroy() {
		log.debug("Filter dest...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		log.debug("Filter before do");
		chain.doFilter(req, resp);
		log.debug("Filter after do");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.debug("Filter init");
	}

}
