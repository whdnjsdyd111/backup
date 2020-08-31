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
	<div id="main_user_cert" class="box2">
		<div id="main_image" class="box">
			<img alt="이미지가 없습니다." src="mollahalf.png" id="logo" class="noborder"
				style="background-color: red" width="100" height="100">
		</div>
		<div id="main_auth" class="box">
			<jsp:include page="loginForm.jsp" />
		</div>
	</div>
	<div id="main_board" class="box2">
		<jsp:include page="main_board.jsp" />
	</div>
</body>
</html>