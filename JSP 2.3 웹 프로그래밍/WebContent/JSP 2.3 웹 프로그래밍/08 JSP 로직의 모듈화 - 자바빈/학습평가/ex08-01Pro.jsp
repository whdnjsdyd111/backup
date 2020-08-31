<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>

	<jsp:useBean id="testBean" class="ch08.ExTestBean">
		<jsp:setProperty name="testBean" property="*" />
	</jsp:useBean>

	이름 :
	<jsp:getProperty property="name" name="testBean" />
	<br> 이메일 :
	<jsp:getProperty property="email" name="testBean" />
	<br> 방문소감 :
	<jsp:getProperty property="comment" name="testBean" />
</body>
</html>