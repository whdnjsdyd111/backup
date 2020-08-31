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
		int num = Integer.parseInt(request.getParameter("value"));	%>

	입력값에 대한 결과 :
	<%
		if(num < 10) { %>
	10보다 작은 값
	<%	} else {	%>
	10보다 크거나 같은 값
	<%	} %>

</body>
</html>