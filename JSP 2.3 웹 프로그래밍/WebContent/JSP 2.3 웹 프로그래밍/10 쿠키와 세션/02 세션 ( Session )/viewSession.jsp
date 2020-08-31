<%@page import="java.util.*"%>
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
		Enumeration <String>attr = session.getAttributeNames();
	
		while(attr.hasMoreElements()) {
			String attrName = attr.nextElement();
			String attrValue = (String) session.getAttribute(attrName);
			out.println("세션의 속성명은 " + attrName + " 이고");
			out.println("세션의 속성값은 " + attrValue + "이다.<br>");
		}
	%>
</body>
</html>