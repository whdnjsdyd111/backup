<%@page import="ch11.LogonDataBean"%>
<%@page import="ch11.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js">
</script>
<script type="text/javascript" src="modify.js">
</script>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	
	<%
		String id = (String) session.getAttribute("id");
		String passwd = (String) session.getAttribute("passwd");
		
		LogonDBBean manager = LogonDBBean.getInstance();
		// 아이디와 비밀번호에 해당하는 사용자의 정보를 얻어냄
		LogonDataBean m = manager.getMember(id, passwd);
		
		try {	// 얻어낸 사용자 정보를 화면에 표시
	%>
			<div id="regForm" class="box">
				<ul>
					<li><p class="center">회원 정보 수정
					<li><label for="id">아이디</label>
						<input id="id" name="id" type="email" size="20"
							maxlength="50" value="<%= id %>" readonly="readonly" disabled="disabled">
					<li><label for="passwd">비밀번호</label>
						<input id="passwd" name="passwd" type="password"
							size="20" placeholder="6~16 숫자/문자" maxlength="16">
					<li><label for="name">이름</label>
						<input id="name" name="name" type="text"
							size="20" maxlength="10" value="<%= m.getName() %>">
					<li><label for="address">주소</label>
						<input id="address" name="address" type="text"
							size="30" maxlength="50" value="<%= m.getAddress() %>">
					<li><label for="tel">전화번호</label>
						<input id="tel" name="tel" type="tel"
							size="20" maxlength="20" value="<%= m.getTel() %>">
					<li class="label2"><button id="modifyProcess">수정</button>
						<button id="cancel">취소</button>
				</ul>
			</div>
	<%
		}catch (Exception e) {}
	%>
</body>
</html>