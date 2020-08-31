<%@page import="ch10.LogonDBBean"%>
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

	<%
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		LogonDBBean logon = LogonDBBean.getInstance();
		int check = logon.userCheck(id, passwd);
		
		if(check == 1){
			session.setAttribute("id", id);
			response.sendRedirect("sessionLogin.jsp");
		} else if(check == 0) {
	%>
	<script type="text/javascript">
				alert("비밀번호가 맞지 않습니다.");
				history.go(-1);
			</script>
	<%
		} else {
	%>
	<script type="text/javascript">
				alert("아이디가 맞지 않습니다.");
			</script>
	<%
		}
	%>
</body>
</html>