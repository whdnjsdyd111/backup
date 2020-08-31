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
	<div id="status">
		<ul>
			<li><label for="passwd">비밀번호</label>
				<input id="passwd" name="passwd" type="password"
					size="20" placeholder="6~16 숫자/문자" maxlength="15">
			<li class="label2">
				<button id="modify">정보수정</button>
				<button id="delete">탈퇴</button>
		</ul>
	</div>
</body>
</html>