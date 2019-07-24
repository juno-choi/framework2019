package com.bit.framework;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlets extends HttpServlet {
	
	
	//매번 map에 put을 하는게 아니라 servlet init실행(init은 최초 한번만 실행됨)될때 한번만 넣어주고 그 값을 계속 뽑아 쓰기 위해서
	@Override
	public void init() throws ServletException {
		Properties prop = new Properties();
		Class<? extends DispatcherServlets> clz = getClass();
		ClassLoader loader = clz.getClassLoader();
		InputStream is = loader.getResourceAsStream("bit.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set keys = prop.keySet();
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()){
			String key = ite.next();
			String clInfo=prop.getProperty(key);
			BitHandlerMapping.setMap(key, clInfo);
		}
		
		
		
//		아래 작업을 bit.properties를 생성함으로 필요가 없어짐
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("/index.bit", "com.bit.controller.IndexController");
//		map.put("/main.bit", "com.bit.controller.MainController");
//		map.put("/list.bit", "com.bit.controller.ListController");
//		map.put("/add.bit", "com.bit.controller.AddController");
//		map.put("/insert.bit", "com.bit.controller.InsertController");
//		
//		Set<String> keys = map.keySet();
//		Iterator<String> ite = keys.iterator();
//		while(ite.hasNext()){
//			String key = ite.next();
//			String clInfo=map.get(key);
//			BitHandlerMapping.setMap(key, clInfo);
//		}
		
	}
	
	//struts에 필터 매핑하는 것
	//스프링은 서블릿을 이용
	//servlet을 상송하여 사용
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doDo(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//한글 처리를 위해~
		doDo(req, resp);
		
	}
	//doDo라는 메서드를 생성함
	//doGet이던 doPost던 doDo를 호출함
	public void doDo (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String root=req.getContextPath();
		String path=req.getRequestURI().substring(root.length());
//		System.out.println("->" + path);
//		System.out.println("->" + root);
		String clInfo=null;
		Controller controller=null;
	
		controller=BitHandlerMapping.getController(path);
		//path를 map key로 사용하여 그에 따른 value로 url을 뽑아주면 if문 없이 간편하게 사용할 수 있음

		String viewName=null;
		try {
			viewName=controller.execute(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		// viewResolver
		
		if(viewName.startsWith("redirect:")){
			
			resp.sendRedirect(root+viewName.substring("redirect:".length()));
		}else{
			String prefix="/WEB-INF/view/";
			String suffix=".jsp";
		
			viewName=prefix+viewName+suffix;
//			jsp에 직접 접근하는 것을 막기 위해 INF-view아래로 수정함
//			그리고 view를 한 페이지마다 입력하지 않고 모든 페이지에 적용해주기 위해서 위처럼 코딩해줌
//			확장자도 코딩하기 귀찮으니까 여기서 다 해줌
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
	
}
