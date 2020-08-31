<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Shoppingmall/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Shoppingmall/qna/write.js"></script>
<c:if test="${ empty sessionScope.id }">
	<meta http-equiv="Refresh" content="0; url=/Shoppingmall/index.do">
</c:if>
</head>
<body>
	<input type="hidden" id="qna_writer" value="${ sessionScope.id }" >
	<input type="hidden" id="book_kind" value="${ book_kind }" >
	<input type="hidden" id="book_id" value="${ book_id }" >
	<input type="hidden" id="book_title" value="${ book_title }" >
	<input type="hidden" id="qora" value="${ qora }" >
	
	<div id="writeForm" class="box">
		<ul>
			<li>[${ book_title }]에 대한 Qna
			<li><label for="content">내용</label>
				<textarea rows="13" cols="50" id="qnaCont"></textarea>
			<li class="label2">
				<button id="regist">등록</button>
				<button id="cancel">취소</button>
		</ul>
	</div>
</body>
</html>