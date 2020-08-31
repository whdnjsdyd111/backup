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
		request.setAttribute("id", "jowonyong@naver.com");
		request.setAttribute("name", "조원용");
	%>

	forwardFrom.jsp 페이지입니다.
	<br> 화면에 절대로 표시되지 않습니다.

	<jsp:forward page="forwardTo.jsp"></jsp:forward>
</body>
</html>