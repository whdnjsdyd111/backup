<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:if test="${ empty sessionScope.id }">
	<meta http-equiv="Refresh" content="0; url=/Shoppingmall/index.do">
</c:if>
</head>
<body>
	<div id="orderResult">
		<p>${ orderStus }
	</div>
	
	<div id="buyProcess">
		<form id="buyPro" method="post" action="/Shoppingmall/buyList.do">
			<input type="hidden" name="buyer" value="${ sessionScope.id }">
			<input type="submit" value="주문확인">
		</form>
	</div>
</body>
</html>