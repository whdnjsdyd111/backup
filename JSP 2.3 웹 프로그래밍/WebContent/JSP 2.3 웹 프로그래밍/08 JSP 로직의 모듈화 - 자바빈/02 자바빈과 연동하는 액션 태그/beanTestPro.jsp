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

	<jsp:useBean id="testBean" class="ch08.TestBean">
		<jsp:setProperty name="testBean" property="id" />
	</jsp:useBean>

	입력된 아이디 :
	<jsp:getProperty property="id" name="testBean" />
</body>
</html>