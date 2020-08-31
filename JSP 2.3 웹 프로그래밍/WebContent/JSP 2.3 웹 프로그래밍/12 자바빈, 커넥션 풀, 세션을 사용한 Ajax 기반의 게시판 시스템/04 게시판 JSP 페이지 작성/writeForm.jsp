<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js">
</script>
<script type="text/javascript" src="write.js">
</script>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	
	<%
		// 제목글의 경우 갖는 값
		int num = 0, ref = 1, re_step = 0, re_level = 0;
		int pageNum = 1;
		
		try {	// 댓글의 경우 갖는 값
			if(request.getParameter("num") != null) {	// 댓글
				// 제목글의 글번호, 그룹화 번호, 그룹화 내의 순서, 들여쓰기 정도가
				// list.jsp 페이지에서 넘어옴
				num = Integer.parseInt(request.getParameter("num"));
				ref = Integer.parseInt(request.getParameter("ref"));
				re_step = Integer.parseInt(request.getParameter("re_step"));
				re_level = Integer.parseInt(request.getParameter("re_level"));
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			}
	%>
			<input type="hidden" id="num" value="<%= num %>">
			<input type="hidden" id="ref" value="<%= ref %>">
			<input type="hidden" id="re_step" value="<%= re_step %>">
			<input type="hidden" id="re_level" value="<%= re_level %>">
			
			<div id="writeForm" class="box">
				<ul>
					<li><label for="subject">제목</label>
					<%	if(num != 0) {	// 댓글 %>
							<img src="re.gif" style="background-color: blue" width="10" height="10" />
					<%	} %>
						<input id="subject" name="subject" type="text"
							size="50" placeholder="제목" maxlength="50">
					<li><label for="content">내용</label>
						<textarea rows="13" cols="50" id="content"></textarea>
					<li><label for="passwd">비밀번호</label>
						<input id="passwd" name="passwd" type="password"
							size="20" placeholder="6 ~ 16 숫자/문자" maxlength="16">
					<li class="label2">
						<button id="regist" value="<%= pageNum %>">등록</button>
						<button id="cancel" value="<%= pageNum %>">취소</button>
				</ul>
			</div>
	<%
		} catch(Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>