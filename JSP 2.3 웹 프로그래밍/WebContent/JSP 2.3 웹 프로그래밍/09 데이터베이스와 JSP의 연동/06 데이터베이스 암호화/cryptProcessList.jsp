<%@page import="ch09.UpdateDataBean"%>
<%@page import="ch09.UpdateDBBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<UpdateDataBean> memberList = null;
		UpdateDBBean dbPro = UpdateDBBean.getInstance();
		memberList = dbPro.getMembers();
	%>

	<table border="1">
		<tr class="label">
			<td>아이디
			<td>비밀번호 <%
		for(int i = 0; i < memberList.size(); i++) {
			UpdateDataBean member = (UpdateDataBean) memberList.get(i);
			
			String id = member.getId();
			String passwd = member.getPasswd();
	%>
		<tr>
			<td><%= id %>
			<td><%= passwd %> <%	} %>
	</table>
</body>
</html>