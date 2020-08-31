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
	<%
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		session.setAttribute("name", name);
		session.setAttribute("content", content);
		
		response.sendRedirect("ex04-01Form.jsp");
	%>
</body>
</html>