<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Shoppingmall/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Shoppingmall/mngr/qnaProcess/qnawriter.js"></script>
<c:if test="${ empty sessionScope.id }">
	<meta http-equiv="Refresh" content="0; url=/Shoppingmall/mg/managerMain.do">
</c:if>
</head>
<body>
	<input type="hidden" id="qna_writer" value="manager">
	<input type="hidden" id="qna_id" value="${ qna_id }">
	<input type="hidden" id="book_id" value="${ book_id }">
	<input type="hidden" id="book_title" value="${ book_title }">
	<input type="hidden" id="qora" value="${ qora }">
	
	<div id="writeForm" class="box">
		<ul>
			<li><p>[${ book_title }] 의 QnA </p>
				<p>QnA 내용 : ${ qna_content }</p>
			<li><label for="rContent">답변</label>
				<textarea id="rContent" row="13" cols="50"></textarea>
			<li class="label2">
				<button id="replyPro">답변하기</button>
				<button id="cancel">취소</button>
		</ul>
	</div>
</body>
</html>