<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js">
</script>
</head>
<body>
	<%
		String id = "";
	
		try {
			id = (String) session.getAttribute("id");
	%>
	<% 
			if(id == null || id.equals("")) {
	%>
				<div id="display_board" class="box2">로그인하세요! 게시판은 회원만 볼 수 있습니다.</div>
	<%
			} else {
	%>
				<div id="display_board" class="box2">
					<jsp:include page="list.jsp"></jsp:include>
				</div>
	<%
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>