<%@page import="ch12.BoardDataBean"%>
<%@page import="ch12.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js">
</script>
<script type="text/javascript" src="update.js">
</script>
<script>
	
</script>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>	
	
	<%
		// 수정할 글의 번호와 수정할 글이 위치한 페이지 번호를 얻어냄
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardDBBean dbPro = BoardDBBean.getInstance();
		// 주어진 글번호에 해당하는 수정할 글을 가져옴
		BoardDataBean article = dbPro.updateGetArticle(num);
	%>
	
	<%-- 수정한 글의 원래 저장 내용을 글수정폼에 표시 --%>
	<div id="editForm" class="box">
		<ul>
			<li><p class="center">글수정
			<li><label for="subject">제목</label>
				<input id="subject" name="subject" type="text"
					size="50" maxlength="50" value="<%= article.getSubject() %>">
				<input type="hidden" id="num" value="<%= num %>">
			<li><label for="content">내용</label>
				<textarea id="content" rows="13"
					cols="50"><%= article.getContent() %></textarea>
			<li><label for="passwd">비밀번호</label>
				<input id="passwd" name="passwd" type="password"
					size="20" placeholder="6 ~ 16 숫자/문자" maxlength="16">
			<li class="label2">
				<button id="update" value="<%= pageNum %>">수정</button>
				<button id="cancel" value="<%= pageNum %>">취소</button>
		</ul>
	</div>
</body>
</html>