<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js">
</script>
<script type="text/javascript" src="login.js">
</script>
</head>
<body>
	<div id="main_image" class="box">
		<img class="noborder" id="logo" src="mollahalf.png" width="300" height="200" style="background-color: red">
	</div>
	<div id="main_auth" class="box"><jsp:include page="loginForm.jsp" /></div>
</body>
</html>