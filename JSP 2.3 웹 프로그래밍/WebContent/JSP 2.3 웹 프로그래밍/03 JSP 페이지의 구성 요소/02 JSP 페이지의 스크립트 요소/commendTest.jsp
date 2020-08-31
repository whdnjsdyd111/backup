<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<h2>주석 예제</h2>
	<%
		// 자바 주석
		
		String str1 = "소스 보기하면 표시됨";
		String str2 = "소스 보기 해도 표시 안됨";
	%>

	<!-- HTML 주석 <%= str1 %> -->
	<%-- JSP 주석 <%= str2 %> --%>
</body>
</html>