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

	<h2>포워딩하는 페이지 : forwardParamTo.jsp</h2>

	<%
		String name = request.getParameter("name");
		String selectedColor = request.getParameter("color");
		String selectedPage = selectedColor + ".jsp";
	%>

	<jsp:forward page="<%= selectedPage %>">
		<jsp:param name="selectedColor" value="<%= selectedColor %>" />
		<jsp:param name="name" value="<%= name %>" />
	</jsp:forward>
</body>
</html>