<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js">
</script>
<script type="text/javascript" src="delete.js"></script>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	
	<%
		// 삭제할 글의 번호와 삭제할 글이 위치한 페이지 번호를 얻어냄
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
	%>
	
	<div id="deleteForm">
		<ul>
			<li><p class="center">글삭제
			<li><label for="passwd">비밀번호</label>
				<input id="passwd" name="passwd" type="password"
					size="20" placeholder="6 ~ 16 숫자/문자" maxlength="16">
				<input type="hidden" id="num" value="<%= num %>">
			<li class="label2">
				<button id="delete" value="<%= pageNum %>">삭제</button>
				<button id="cancel" value="<%= pageNum %>">취소</button>
		</ul>
	</div>
</body>
</html>