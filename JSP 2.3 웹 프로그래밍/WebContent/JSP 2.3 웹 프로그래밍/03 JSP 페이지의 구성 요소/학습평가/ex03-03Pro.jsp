<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int number = Integer.parseInt(request.getParameter("number"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		long multiply = 1;

		for(int i = 0; i < num; i++) {
			multiply *= number;
		}
	%>
	결과 :
	<%= multiply %>
</body>
</html>