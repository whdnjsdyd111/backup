<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tagFile" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>태그 파일을 사용한 커스텀 태그 작성 예제 - 속성이 있는 태그</h3>
	
	<c:set var="welcome" value="환영합니다." />
	
	<form method="post" action="#">
		<input type="text" name="name" >
		<input type="submit" value="Submit">
	</form>
	
	<c:if test="${ fn:length(param.name) > 0 }">
		<tagFile:attribute name="${ param.name }" welcome="${ welcome }"></tagFile:attribute>
	</c:if>
</body>
</html>