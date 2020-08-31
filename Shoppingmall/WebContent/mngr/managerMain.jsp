<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Shoppingmall/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Shoppingmall/mngr/managerMain.js"></script>
</head>
<body>
	<c:if test="${ empty sessionScope.id }">
		<div id="mList">
			<p>로그인 하세요.
		</div>
	</c:if>
	<c:if test="${ !empty sessionScope.id }">
		<div id="mList">
			<ul>
				<li>상품 관련 작업
				<li><button id="registProduct">상품 등록</button>
				<li><button id="updateProduct">상품 수정/삭제</button>
			</ul>
			<ul>
				<li>구매된 상품관련 작업
				<li><button id="orderedProduct">전체구매목록 확인</button>
			</ul>
			<ul>
				<li>상품 QnA 작업
				<li><button id="qna">상품 QnA 답변</button>
			</ul>
		</div>
	</c:if>
</body>
</html>