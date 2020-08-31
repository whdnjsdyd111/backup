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
		String sports = "eSports";
		String name = "홍길동";
	%>

	<jsp:forward page="ex05-03To.jsp">
		<jsp:param value="<%= name %>" name="name" />
		<jsp:param value="<%= sports %>" name="sports" />
	</jsp:forward>
</body>
</html>