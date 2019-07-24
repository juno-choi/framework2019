<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String[] strs={"ab","abc","abcd","abcde","abcdef"};
	ArrayList<String> alist = new ArrayList<String>();
	alist.add("ab");
	alist.add("abc");
	alist.add("abcd");
	alist.add("abcde");
	
	
	HashSet<String> hset = new HashSet<String>();
	hset.add("a");
	hset.add("ab");
	hset.add("abc");
	hset.add("abcd");
	
	HashMap<String,String> hmap=new HashMap<String,String>();
	hmap.put("key1", "val1");
	hmap.put("key2", "val2");
	hmap.put("key3", "val3");
	hmap.put("key4", "val4");
	
	pageContext.setAttribute("strs", strs);
	//pageContext.setAttribute("list", alist);
	//pageContext.setAttribute("list", hset);
	pageContext.setAttribute("map", hmap);
	
	com.bit.entity.JavaBean bean = null;
	bean = new com.bit.entity.JavaBean();
	bean.setSu(1234);
	bean.setSu2(3.14);
	bean.setCh('A');
	bean.setBoo(true);
	bean.setMsg("EL");
	bean.setNalja(new java.util.Date());
	pageContext.setAttribute("bean", bean);
	
%>

<body>
	<h1>자료 표현</h1>
	
	<ul>
		<li>${bean.su }</li>
		<li>${bean.su2 }</li>
		<li>${bean.ch }</li>
		<li>${bean.boo }</li>
		<li>${bean.msg }</li>
		<li>${bean.nalja }</li>
	</ul>
	
</body>
</html>