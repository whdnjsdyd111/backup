<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>

	<%
		String name = request.getParameter("name");
		
		if(name == "김개동")
			out.println("관리자님 어서오세요");
		else
			out.println("회원님 어서오세요");
		
	%>
</body>
</html>