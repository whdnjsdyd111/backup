<%@page import="java.sql.Timestamp"%>
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
	<% request.setCharacterEncoding("utf-8"); %>

	<jsp:useBean id="registerBean" class="ch08.RegisterBean">
		<jsp:setProperty name="registerBean" property="*" />
	</jsp:useBean>

	<% // 현재 날짜와 시간을 가입일로 지정
		registerBean.setReg_date(new Timestamp(System.currentTimeMillis()));
	%>

	<table class="content">
		<tr>
			<td>아이디
			<td><jsp:getProperty property="idt" name="registerBean" />
		<tr>
			<td>비밀번호
			<td><jsp:getProperty property="passwd" name="registerBean" />
		<tr>
			<td>이름
			<td><jsp:getProperty property="name" name="registerBean" />
		<tr>
			<td>가입일
			<td><jsp:getProperty property="reg_date" name="registerBean" />
	</table>
</body>
</html>