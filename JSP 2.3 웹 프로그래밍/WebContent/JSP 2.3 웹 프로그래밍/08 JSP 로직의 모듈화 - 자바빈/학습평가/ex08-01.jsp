<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ex08-01Pro.jsp" method="post">
		<dl>
			<dd>
				<label for="name">이름</label> <input id="name" name="name"
					type="text" size="20" placeholder="홍길동" maxlength="10"
					autofocus="autofocus">
			</dd>
			<dd>
				<label for="email">이메일</label> <input id="email" name="email"
					type="email" size="30" placeholder="aaaa@aaa.com" maxlength="50">
			</dd>
			<dd>
				<label for="comment">방문소감</label>
				<textarea rows="10" cols="50" id="comment" name="comment"></textarea>
			</dd>
			<dd>
				<label for="passwd">비밀번호</label> <input id="passwd" name="passwd"
					type="password" size="20" placeholder="6 ~ 16 숫자/문자" maxlength="16">
			</dd>
		</dl>

		<button type="submit">확인</button>
	</form>

</body>
</html>