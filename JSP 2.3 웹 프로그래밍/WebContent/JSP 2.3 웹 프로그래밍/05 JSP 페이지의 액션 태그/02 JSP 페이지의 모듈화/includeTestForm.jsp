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
	<form method="post" action="includeTest.jsp">
		<dl>
			<dd>
				<label for="name">이름</label> <input id="name" name="name"
					type="text" placeholder="홍길동" autofocus required>
			</dd>
			<dd>
				<label for="pagename">포함할 페이지</label> <input id="pagename"
					name="pageName" type="text" value="includedTest.jsp"
					required="required">
			</dd>
			<dd>
				<input type="submit" value="전송">
			</dd>
		</dl>
	</form>
</body>
</html>