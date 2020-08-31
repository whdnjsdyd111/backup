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
	<form method="get" action="#">
		<dl>
			<dd>
				<label for="val1">값1</label> <input id="val1" name="val1"
					type="text" placeholder="1" required="required">
			</dd>
			<dd>
				<label for="val2">값2</label> <input id="val2" name="val2"
					type="text" placeholder="2" required="required">
			</dd>
			<dd>
				<input type="submit" value="결과">
			</dd>
		</dl>
	</form>

	<%
		int val1 = Integer.parseInt(request.getParameter("val1"));
		int val2 = Integer.parseInt(request.getParameter("val2"));
						
		if(val1 + val2 >= 5)
			out.println("두 값의 합이 5 이상");
		else
			out.println("두 값의 합이 5 미만");
	%>
</body>
</html>