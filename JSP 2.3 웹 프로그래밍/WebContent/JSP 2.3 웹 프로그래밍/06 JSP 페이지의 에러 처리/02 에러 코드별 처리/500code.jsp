<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>500 에러 페이지</title>
</head>
<body>
	<% response.setStatus(HttpServletResponse.SC_OK); %>

	<img src="http://localhost:8080/study.jsp/error/notfound.jsp">
</body>
</html>