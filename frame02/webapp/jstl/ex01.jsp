<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <!-- prefix "X" X는 c로 지정할 수 있는데 아무 문자나 넣을 수 있다. 하지만 프로그래머끼리 약속이니까 맘대로 하지마 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>jstl</h1>
	
	<ul>
	<li><c:out value="1234"></c:out></li>
	<li><c:out value="1234+1"></c:out></li>
	<li><c:out value="java">ohoh</c:out></li>
	<li><c:out value="${null}">ohoh</c:out></li>
	</ul>
	
	<ul>
	<c:set var="msg" value="abcd" scope="page"></c:set>
		<li>${pageScope.msg}</li>
		<li>${rquestScope.msg}</li>
		<li>${sessionScope.msg}</li>
		<li>${applicationScope.msg}</li>
	</ul>
	
	<jsp:useBean id="bean" class="com.bit.entity.JavaBean" scope="page"></jsp:useBean>
	<c:set target="${bean }" property="su" value="1234"></c:set>
	<c:set target="${bean }" property="nalja" value="<%=new java.util.Date() %>"></c:set>
	<ul>
		<li>${bean.su }</li>
		<li>${bean.nalja }</li>
	</ul>
	
	
		
</body>
</html>