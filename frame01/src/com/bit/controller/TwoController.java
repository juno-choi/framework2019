package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TwoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//web.xml에 매핑할때 param값을 msg 주어 파라미터 전송 
		
		String cmsg=this.getServletContext().getInitParameter("cmsg");
		System.out.println(cmsg);
		
		String msg=getInitParameter("msg");
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("two.jsp").forward(req, resp);
	}

}
