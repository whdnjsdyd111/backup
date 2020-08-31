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
	<h2>방명록</h2>
	<%
		if(session.getAttribute("name") == null) {
	%>
	<form action="ex04-01Pro.jsp">
		<label for="name">이름</label> <input type="text" id="name" name="name"
			required><br> <label for="content">내용</label> <input
			type="text" id="content" name="content" required><br> <input
			type="submit" value="등록"> <input type="reset" value="다시쓰기">
	</form>

	<%	} else { %>
	<form>
		<label>이름 : <%= session.getAttribute("name") %></label><br> <label>내용
			: <%= session.getAttribute("content") %></label>
	</form>
	<%	} %>
</body>
</html>