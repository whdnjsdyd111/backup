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
	<h2>application 내장 객체</h2>
	<%
		String info = application.getServerInfo();
		String path = application.getRealPath("/");
		application.log("로그 기록");
		if(application.getAttribute("count") == null)
			application.setAttribute("count", new Integer(0));
		else
			application.setAttribute("count", (Integer) application.getAttribute("count") + 1);
	%>

	웹 컨테이너의 이름과 버전 :
	<%= info %><p>
		웹 애플리케이션 폴더의 로컬 시스템 경로 :
		<%= path %>
			방문 카운트:
			<%= application.getAttribute("count") %>
</body>
</html>