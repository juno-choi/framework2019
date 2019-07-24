package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

// "/"로 url을 주어 모든 주소에서 MainController가 실행되게 함
@WebServlet("/")
public class MainController extends HttpServlet {
	Logger logger = Logger.getLogger(MainController.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		BasicConfigurator.configure();
//		trace < debug < info < warn < error < fatal 
		logger.trace("확인");
		logger.debug("개발자모드");
		logger.info("정보제공");
		logger.warn("경고");
		logger.error("에러");
		logger.fatal("치명적인");
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
