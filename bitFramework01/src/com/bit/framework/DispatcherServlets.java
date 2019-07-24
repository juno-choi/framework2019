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
	
	
	//�Ź� map�� put�� �ϴ°� �ƴ϶� servlet init����(init�� ���� �ѹ��� �����)�ɶ� �ѹ��� �־��ְ� �� ���� ��� �̾� ���� ���ؼ�
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
		
		
		
//		�Ʒ� �۾��� bit.properties�� ���������� �ʿ䰡 ������
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
	
	//struts�� ���� �����ϴ� ��
	//�������� ������ �̿�
	//servlet�� ����Ͽ� ���
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doDo(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//�ѱ� ó���� ����~
		doDo(req, resp);
		
	}
	//doDo��� �޼��带 ������
	//doGet�̴� doPost�� doDo�� ȣ����
	public void doDo (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String root=req.getContextPath();
		String path=req.getRequestURI().substring(root.length());
//		System.out.println("->" + path);
//		System.out.println("->" + root);
		String clInfo=null;
		Controller controller=null;
	
		controller=BitHandlerMapping.getController(path);
		//path�� map key�� ����Ͽ� �׿� ���� value�� url�� �̾��ָ� if�� ���� �����ϰ� ����� �� ����

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
//			jsp�� ���� �����ϴ� ���� ���� ���� INF-view�Ʒ��� ������
//			�׸��� view�� �� ���������� �Է����� �ʰ� ��� �������� �������ֱ� ���ؼ� ��ó�� �ڵ�����
//			Ȯ���ڵ� �ڵ��ϱ� �������ϱ� ���⼭ �� ����
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
	
}
