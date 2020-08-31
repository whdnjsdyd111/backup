<%@page import="ch09.UpdateDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>암호화 전 내용</h3>
	<jsp:include page="cryptProcessList.jsp" flush="false" />

	<%
		UpdateDBBean dbPro = UpdateDBBean.getInstance();
		dbPro.updateMember();
	%>

	<h3>암호화가 적용된 후 내용</h3>
	<jsp:include page="cryptProcessList.jsp" flush="false" />
</body>
</html>