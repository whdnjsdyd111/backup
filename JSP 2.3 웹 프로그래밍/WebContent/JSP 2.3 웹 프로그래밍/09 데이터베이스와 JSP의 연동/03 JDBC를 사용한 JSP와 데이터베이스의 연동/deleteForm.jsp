<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="deletePro.jsp">
		<table>
			<tr>
				<td class="label"><label for="idt">아이디</label>
				<td class="content"><input id="idt" name="idt" type="text"
					size="20" maxlength="30" placeholder="example@kings.com"
					autofocus="autofocus" required="required">
			<tr>
				<td class="label"><label for="passwd">비밀번호</label>
				<td class="content"><input id="passwd" name="passwd"
					type="password" size="20" maxlength="30" placeholder="6~12자 숫자/문자"
					maxlength="12" required="required">
			<tr>
				<td class="label2" colspan="2"><input type="submit" value="삭제">
					<input type="reset" value="다시 작성">
		</table>
	</form>
</body>
</html>