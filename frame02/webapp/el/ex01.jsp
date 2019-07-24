<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 표현식</h1>
	<table>
		<tr>
			<th>출력</th>
			<th>java</th>
			<th>EL</th>
			<th>설명</th>
		</tr>
		<tr>
			<td>String</td>
			<td><%="java"%></td>
			<td>${"el"}</td>
			<td>같다</td>
		</tr>
		<tr>
			<td>String</td>
			<td><%out.print("JAVA"); %></td>
			<td>${'EL'}</td>
			<td>EL은'',"" 구분이 없다</td>
		</tr>
		<tr>
			<td>숫자(정수)</td>
			<td><%=1234+1 %></td>
			<td>${1234+1}</td>
			<td>같다</td>
		</tr>
		<tr>
			<td>숫자(정수:나눗셈)</td>
			<td><%=6/2 %></td>
			<td>${6 div 2}</td>
			<td>EL은 div로도 연산가능 소수점을 표현해준다</td>
		</tr>
		<tr>
			<td>숫자(정수:나머지)</td>
			<td><%=7%2 %></td>
			<td>${7%2}</td>
			<td>같다</td>
		</tr>
		<tr>
			<td>실수</td>
			<td><%=3.14 %></td>
			<td>${3.14}</td>
			<td>같다</td>
		</tr>
		<tr>
			<td>실수(연산+-/)</td>
			<td><%=6.000000000000000000001*2 %></td>
			<td>${6.000000000000000000001*2}</td>
			<td>오차범위가 똑같다</td>
		</tr>
		<tr>
			<td>true/false</td>
			<td><%=true %></td>
			<td>${true}</td>
			<td>같다</td>
		</tr>
		<tr>
			<td>비교연산자(==)</td>
			<td><%=3==2 %></td>
			<td>${3 eq 2}</td>
			<td>EL은 같다=와 eq로 표현 가능</td>
		</tr>
		<tr>
			<td>비교연산자(>)</td>
			<td><%=3>2 %></td>
			<td>${3 gt 2}</td>
			<td>EL은 같다=와 gt로 표현 가능</td>
		</tr>
		<tr>
			<td>비교연산자(<)</td>
			<td><%=3<2 %></td>
			<td>${3 lt 2}</td>
			<td>EL은 같다=와 lt로 표현 가능</td>
		</tr>
		<tr>
			<td>비교연산자(=>)</td>
			<td><%=3>=2 %></td>
			<td>${3 ge 2}</td>
			<td>EL은 같다=와 ge로 표현 가능</td>
		</tr>
		<tr>
			<td>비교연산자(=<)</td>
			<td><%=3<=2 %></td>
			<td>${3 le 2}</td>
			<td>EL은 같다=와 le 표현 가능</td>
		</tr>
		<tr>
			<td>null</td>
			<td><%
			String msg=null;
			out.print(msg);
			%></td>
			<td>${msg2 }</td>
			<td>EL에서 null은 표현해주지 않는다.</td>
		</tr>
		
	</table>

</body>
</html>