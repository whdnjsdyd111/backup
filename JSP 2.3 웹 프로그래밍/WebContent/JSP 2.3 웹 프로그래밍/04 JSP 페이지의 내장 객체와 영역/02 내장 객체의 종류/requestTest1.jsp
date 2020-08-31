<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
	<h2>request 예제 - 요청 메소드</h2>
	<%	// request 객체에서 파라메터값을 얻어냄
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String hobby = request.getParameter("hobby");
		
		// 성별값 처리
		if(gender.equals("m"))
			gender = "남자";
		else
			gender = "여자";
	%>

	<%-- DB 연동을 위한 작업 --%>
	<%-- 화면 출력 --%>
	<%= name %>
	님의 정보는 다음과 같습니다.
	<p>
		나이 :
		<%= age %>
		<br> 성별 :
		<%= gender %>
		<br> 취미 :
		<%= hobby %>
</body>
</html>