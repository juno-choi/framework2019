<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>제어문</h1>
	<h2>조건문</h2>
	<c:set var="su1" value="3"></c:set>
	<c:if test="${3 ge su1 }">
		<c:if test="${3 eq su1 }">
			<p>같다</p>
		</c:if>
		<c:if test="${3 ne su1 }">
			<p>크다</p>
		</c:if>
	</c:if>
	<!-- else가 없음 무조건 if로만 짜야함~ -->
	
	<c:choose>
		<c:when test="${su1 eq 0 }">0입니다</c:when>
		<c:when test="${su1 eq 1 }">1입니다</c:when>
		<c:when test="${su1 eq 2 }">2입니다</c:when>
		<c:otherwise>2보다 큽니다</c:otherwise>
	</c:choose>
	
</body>
</html>