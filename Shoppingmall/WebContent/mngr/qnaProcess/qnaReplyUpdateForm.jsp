<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Shoppingmall/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Shoppingmall/mngr/qnaProcess/qnaupdate.js"></script>
<c:if test="${ empty sessionScope.id }">
	<meta http-equiv="Refresh" content="0; url=/Shoppingmall/mg/managerMain.do">
</c:if>
</head>
<body>
	<input type="hidden" id="qna_id" value="${ qna_id }">
	
	<div id="editForm" class="box">
		<ul>
			<li><label for="content">내용</label>
				<textarea id="uRContent" rows="13" cols="50">${ qna.getQna_content() }</textarea>
			<li class="label2">
				<button id="update">수정</button>
				<button id="cancel">취소</button>
		</ul>
	</div>
</body>
</html>