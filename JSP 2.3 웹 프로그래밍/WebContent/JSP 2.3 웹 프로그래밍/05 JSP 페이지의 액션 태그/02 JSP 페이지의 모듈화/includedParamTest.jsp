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
		String pageName = request.getParameter("pageName");
	%>

	파라미터 값을 전달아 실행되는
	<br> 포함되는 페이지
	<%= pageName %>
	입니다.
	<br>
	<b><%= name %> 님 환영입니다. </b>
</body>
</html>