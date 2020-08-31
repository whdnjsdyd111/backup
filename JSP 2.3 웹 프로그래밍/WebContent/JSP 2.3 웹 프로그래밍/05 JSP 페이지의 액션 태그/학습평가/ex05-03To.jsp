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
		String sports = request.getParameter("sports");
		String name = request.getParameter("name");
	%>

	<b><%= name %></b> 님이 좋아하는 스포츠는 "<%= sports %>" 입니다.
</body>
</html>